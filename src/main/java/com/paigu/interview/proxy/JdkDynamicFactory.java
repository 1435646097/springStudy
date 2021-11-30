package com.paigu.interview.proxy;

import java.lang.reflect.Proxy;

/**
 * jdk动态工厂
 *
 * @author LiaoXM
 * @date 2021/11/30
 */
public class JdkDynamicFactory {
	public static Login getLoginProxy(Login login){
		return (Login)Proxy.newProxyInstance(login.getClass().getClassLoader(), login.getClass().getInterfaces(), new LoginInvocationHandler(login));
	}
}
