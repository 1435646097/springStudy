package com.paigu.interview.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class TestMain {
	public static void main(String[] args){
		Stream<Integer> integerStream = Stream.of(2, 3, 4, 5, 4, 3, 3);
		Optional<Integer> max = integerStream.max(Integer::compareTo);
		System.out.println(max.get());
//		long count = integerStream.count();
//		Optional<Integer> first = integerStream.findFirst();
//		System.out.println(count);
//		first.ifPresent(System.out::println);
//		System.out.println(integer);
//		Person person = new Person.Builder().name("我的尼玛")
//		                                    .gender("男")
//		                                    .card("10086")
//		                                    .phone("110")
//		                                    .age("20")
//		                                    .build();
//		System.out.println(person);
		List<Integer> list = new ArrayList<>();
		for (Integer integer : list) {
			System.out.println(integer);
		}
	}
}
