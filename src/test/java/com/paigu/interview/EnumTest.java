package com.paigu.interview;

import com.paigu.interview.Enum.SingletonEnum;

import java.text.DateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;

public class EnumTest {
	public static void main(String[] args){
		System.out.println(SingletonEnum.instance.getName());
		System.out.println(SingletonEnum.person.getName());
		System.out.println(SingletonEnum.student.getName());
		SingletonEnum.student.setName("起飞");
		System.out.println(SingletonEnum.student.getName());
		HashMap<String, String> map = new HashMap<>();
		DateFormat dateInstance = DateFormat.getDateInstance();
		LocalDateTime now = LocalDateTime.now();
		Date date = new Date();
		long time = date.getTime();
		System.out.println(time);
	}
}
