package com.paigu.interview;

import com.paigu.interview.utils.RedisUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author PaiGu
 * @description TODO
 * @date 2022/2/13 16:05
 */
@SpringBootTest
public class RedisTest {
	@Autowired
	private RedisUtils redisUtils;

	@Test
	public void redisTemplateTest(){
		Long a = 20L;
		redisUtils.set("long", a);
	}

	@Test
	public void getRedisTemplateTest(){
		Object aLong = redisUtils.get("long");
		System.out.println(aLong);
	}
}
