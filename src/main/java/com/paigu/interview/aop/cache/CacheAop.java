package com.paigu.interview.aop.cache;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;


@Aspect
@Component
@Slf4j
public class CacheAop {

	@Around("@annotation(redisCache)")
	public Object cache(ProceedingJoinPoint joinPoint, redisCacheAnnotation redisCache) throws Throwable{
		MethodSignature signature = (MethodSignature)joinPoint.getSignature();
		Method method = signature.getMethod();
		log.info("来了来了,方法:{}，参数：{},过期时间为:{}",method.getName() ,method.getParameters()[0].getName(),redisCache.expire());
		return joinPoint.proceed();
	}
}
