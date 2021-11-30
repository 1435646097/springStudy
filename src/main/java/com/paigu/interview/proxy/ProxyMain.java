package com.paigu.interview.proxy;

import org.springframework.cglib.proxy.Enhancer;

/**
 * 代理主运行类
 *
 * @author LiaoXM
 * @date 2021/11/30
 */
public class ProxyMain {
	public static void main(String[] args){
		Boolean result;
		//自定义
		Login login = new DiyLoginProxy(new UserNamePasswordLogin());
		result = login.isSuccess("admin", "123456");
		System.out.println(result);
		//JDK方式
		Login loginProxy = (Login) JdkDynamicFactory.getLoginProxy(new UserNamePasswordLogin());
		result = loginProxy.isSuccess("admin", "123456");
		System.out.println(result);
		//CGLIB
		UserNamePasswordLogin cglibProxy = (UserNamePasswordLogin) Enhancer.create(UserNamePasswordLogin.class, new CglibLoginProxy());
		result = cglibProxy.isSuccess("admin", "123456");
		System.out.println(result);
	}
}
