package com.paigu.interview.Decorator;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * 圆
 *
 * @author LiaoXM
 * @date 2021/10/26
 */
@Slf4j
@Component
public class Circle implements IShape, InitializingBean {
	@Override
	public void draw(){
		System.out.println("画一个：圆形-----");
	}

	@Override
	public void afterPropertiesSet(){
		log.info("spring boot 初始化完成-----");
	}
}
