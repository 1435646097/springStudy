package com.paigu.interview;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableAspectJAutoProxy
@EnableCaching
@EnableAsync
@EnableScheduling
@MapperScan(basePackages = "com.paigu.interview.mapper*")
public class InterviewApplication {

	public static void main(String[] args){
		SpringApplication.run(InterviewApplication.class, args);
	}

}
