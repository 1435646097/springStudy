package com.paigu.interview.proxy;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * cglb登录理
 *
 * @author LiaoXM
 * @date 2021/11/30
 */
public class CglibLoginProxy implements MethodInterceptor {

	@Override
	public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable{
		System.out.println("Gclib增强代理类之前");
		Object result = methodProxy.invokeSuper(o, objects);
		System.out.println("Gclib增强代理类之后");
		return result;
	}
}
