package com.paigu.interview.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * JDK实现的动态代理
 *
 * @author LiaoXM
 * @date 2021/11/30
 */
public class LoginInvocationHandler implements InvocationHandler {
	private final Object login;

	public LoginInvocationHandler(Object login){
		this.login = login;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable{
		System.out.println("JDK登录之前.......");
		Object result = method.invoke(login, args);
		System.out.println("JDK登录完成之后.......");
		return result;
	}
}
