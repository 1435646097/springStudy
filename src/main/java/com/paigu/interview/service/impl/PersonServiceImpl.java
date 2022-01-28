package com.paigu.interview.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.paigu.interview.entity.Person;
import com.paigu.interview.mapper.PersonMapper;
import com.paigu.interview.service.IPersonService;
import org.springframework.stereotype.Service;

/**
 * @author PaiGu
 * @description 人员业务实现类
 * @date 2022/1/28 22:52
 */
@Service
public class PersonServiceImpl extends ServiceImpl<PersonMapper, Person> implements IPersonService {
}
