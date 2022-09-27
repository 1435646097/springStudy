package com.paigu.interview.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.paigu.interview.entity.Person;

import java.io.IOException;

/**
 * @author PaiGu
 * @description 人员业务类接口
 * @date 2022/1/28 22:51
 */
public interface IPersonService extends IService<Person> {
	/**
	 * 创造人员
	 *
	 * @return {@link Boolean}
	 */
	Boolean createPerson(String name) throws IOException;

	/**
	 * 失败人
	 */
	void failPerson();
}
