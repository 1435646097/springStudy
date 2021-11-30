package com.paigu.interview.proxy;

/**
 * 用户名密码登录
 *
 * @author LiaoXM
 * @date 2021/11/30
 */
public class UserNamePasswordLogin implements Login {
	/**
	 * 默认用户名
	 */
	private static final String DEFAULT_USERNAME = "admin";
	/**
	 * 默认密码
	 */
	private static final String DEFAULT_PASSWORD = "123456";

	@Override
	public Boolean isSuccess(String name, String password){
		return DEFAULT_USERNAME.equals(name) && DEFAULT_PASSWORD.equals(password);
	}
}
