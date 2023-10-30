package com.paigu.interview;

import cn.hutool.core.util.IdUtil;
import com.paigu.interview.entity.AutoTest;
import com.paigu.interview.mapper.AutoTestMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AutoTestTest {
   @Autowired
    AutoTestMapper autoTestMapper;

    @Test
    void auto() {
        AutoTest autoTest = new AutoTest();
        autoTest.setName(IdUtil.simpleUUID());
        autoTest.setId(50);
        autoTestMapper.insert(autoTest);
        System.out.println(autoTest);
    }
}
