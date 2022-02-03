package com.paigu.interview.main;

import java.util.Optional;

/**
 * @author PaiGu
 * @description Optional测试
 * @date 2022/2/3 17:33
 */
public class OptionalMain {
	public static void main(String[] args){
		Integer a = null;
		System.out.println(add(a));
	}
	public static Integer add(Integer a){
		a = Optional.ofNullable(a).orElse(0);
		return a + 1;
	}
}
