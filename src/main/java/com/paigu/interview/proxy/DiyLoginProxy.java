package com.paigu.interview.proxy;

/**
 * 自定义登录代理
 *
 * @author LiaoXM
 * @date 2021/11/30
 */
public class DiyLoginProxy implements Login {

	private final Login login;

	public DiyLoginProxy(Login login){
		this.login = login;
	}

	@Override
	public Boolean isSuccess(String name, String password){
		System.out.println("登录前记录日志......");
		Boolean success = login.isSuccess(name, password);
		System.out.println("登录完成......");
		return success;
	}
}
