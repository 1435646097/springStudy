package com.paigu.interview.proxy;

/**
 * 登录接口
 *
 * @author LiaoXM
 * @date 2021/11/30
 */
public interface Login {
	/**
	 * 是否登录成功
	 *
	 * @param name     账号
	 * @param password 密码
	 * @return {@link Boolean}
	 */
	Boolean isSuccess(String name,String password);
}
