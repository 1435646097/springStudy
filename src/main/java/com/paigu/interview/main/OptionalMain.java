package com.paigu.interview.main;

import com.paigu.interview.entity.Book;

import java.lang.reflect.Array;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

/**
 * @author PaiGu
 * @description Optional测试
 * @date 2022/2/3 17:33
 */
public class OptionalMain {

	//实现一个返回Java基本类型默认值的工具。其实，你也可以逐一写很多if-else判断类型，然后手动设置其默认值。
	// 这里为了减少代码量用了一个小技巧，
	// 即通过初始化一个具有1个元素的数组，然后通过获取这个数组的值来获取基本类型默认值
	private static final Map<Class, Object> DEFAULT_VALUES = Stream.of(boolean.class, byte.class, char.class, double.class, float.class, int.class, long.class, short.class)
																   .collect(toMap(clazz -> clazz,
																		   clazz -> Array.get(
																				   Array.newInstance(clazz, 1), 0)));

	public static <T> T getDefaultValue(Class<T> clazz) {
		return (T) DEFAULT_VALUES.get(clazz);
	}
	public static void main(String[] args){
		System.out.println(getDefaultValue(boolean.class));
		System.out.println(getDefaultValue(Book.class));
	}
	public static Integer add(Integer a){
		a = Optional.ofNullable(a).orElse(0);
		return a + 1;
	}
}
