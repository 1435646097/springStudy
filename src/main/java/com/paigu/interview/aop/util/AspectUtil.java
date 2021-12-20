package com.paigu.interview.aop.util;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * 动态代理工具类
 *
 * @author LiaoXM
 * @date 2021/12/20
 */
public class AspectUtil {
	/**
	 * 获取切面原方法
	 *
	 * @param joinPoint       连接点
	 * @param methodSignature 方法签名
	 * @return {@link Method}
	 * @throws NoSuchMethodException 没有这样的方法异常
	 */
	public static Method getMethodByJoinPoint(ProceedingJoinPoint joinPoint, MethodSignature methodSignature) throws NoSuchMethodException{
		Object target = joinPoint.getTarget();
		return target.getClass().getMethod(methodSignature.getName(),methodSignature.getParameterTypes());
	}

	/**
	 * 根据注解得到注释的值
	 *
	 * @param annotation 注释
	 * @param name       属性
	 * @return {@link Object}
	 */
	public static Object getAnnotationValue(Annotation annotation, String name){
		if (ObjectUtil.isNull(annotation) || StrUtil.isBlank(name)) {
			return null;
		}
		try {
			return annotation.annotationType()
			                 .getMethod(name)
			                 .invoke(annotation);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
