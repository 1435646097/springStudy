package com.paigu.interview.proxy;

import java.lang.reflect.Proxy;

/**
 * jdk动态工厂
 *
 * @author LiaoXM
 * @date 2021/11/30
 */
public class JdkDynamicFactory {
	public static Object getLoginProxy(Object target){
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new LoginInvocationHandler(new UserNamePasswordLogin()));
	}
}
