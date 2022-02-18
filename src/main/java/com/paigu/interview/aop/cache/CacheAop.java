package com.paigu.interview.aop.cache;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;


@Aspect
@Component
@Slf4j
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CacheAop {
	@Autowired
	private ObjectMapper objectMapper;

	@Around("@annotation(redisCache)")
	public Object cache(ProceedingJoinPoint joinPoint, redisCacheAnnotation redisCache){
		Object result = null;
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();
		try {
			log.info("来了来了,方法:{}，参数：{},过期时间为:{}", method.getName(), objectMapper.writeValueAsString(joinPoint.getArgs()), redisCache.expire());
			result = joinPoint.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return result;
	}
}
