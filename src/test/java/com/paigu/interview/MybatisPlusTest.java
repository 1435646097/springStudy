package com.paigu.interview;

import com.paigu.interview.entity.Person;
import com.paigu.interview.service.IPersonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author PaiGu
 * @description 人员测试类
 * @date 2022/1/28 22:53
 */
@SpringBootTest
public class MybatisPlusTest {

	@Autowired
	private IPersonService personService;

	@Test
	void save(){
		Person person = new Person.Builder().name("张三")
		                                    .age(20)
		                                    .card("431024199911232123")
		                                    .gender('1')
		                                    .phone("17674111268")
		                                    .build();
		personService.save(person);
	}

	@Test
	void select(){
		List<Person> list = personService.list();
		list.forEach(System.out::println);
	}
}
