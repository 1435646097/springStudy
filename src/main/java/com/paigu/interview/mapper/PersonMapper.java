package com.paigu.interview.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.paigu.interview.entity.Person;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author PaiGu
 * @description 人员mapper类
 * @date 2022/1/28 22:50
 */
@Mapper
public interface PersonMapper extends BaseMapper<Person> {
}
