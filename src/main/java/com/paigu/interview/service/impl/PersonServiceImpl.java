package com.paigu.interview.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.paigu.interview.entity.Info;
import com.paigu.interview.entity.Person;
import com.paigu.interview.mapper.PersonMapper;
import com.paigu.interview.service.IInfoService;
import com.paigu.interview.service.IPersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

/**
 * @author PaiGu
 * @description 人员业务实现类
 * @date 2022/1/28 22:52
 */
@RequiredArgsConstructor
@Service
public class PersonServiceImpl extends ServiceImpl<PersonMapper, Person> implements IPersonService {
	private final IInfoService infoService;

	@Transactional(rollbackFor = Exception.class)
	@Override
	public Boolean createPerson() throws IOException{
//		Person person = new Person.Builder().name("张三")
//		                                    .age(20)
//		                                    .card("431024199911232123")
//		                                    .gender('1')
//		                                    .phone("17674111268")
//		                                    .build();
//		this.save(person);
//		Info info = new Info(person.getId(), "食品加工厂", "郴州市三中", "跑步");
//		infoService.save(info);
////		int a = 10;
////		int b = a / 0;
//		InputStream inputStream = new BufferedInputStream(new InputStream() {
//			@Override
//			public int read() throws IOException{
//				throw new IOException("所读文件不存在");
////				return 0;
//			}
//		});
//		inputStream.read();
		this.subCreatePerson();
		return true;
	}

//	@Transactional
	public void subCreatePerson(){
		Person person = new Person.Builder().name("张三")
		                                    .age(20)
		                                    .card("431024199911232123")
		                                    .gender('1')
		                                    .phone("17674111268")
		                                    .build();
		this.save(person);
		Info info = new Info(person.getId(), "食品加工厂", "郴州市三中", "跑步");
		infoService.save(info);
		int a = 10;
		int b = a / 0;
//		InputStream inputStream = new BufferedInputStream(new InputStream() {
//			@Override
//			public int read() throws IOException{
////				throw new IOException("所读文件不存在");
//				return 0;
//			}
//		});
	}
}
