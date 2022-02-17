package com.paigu.interview.main;

import java.util.HashMap;
import java.util.Map;

/**
 * @author PaiGu
 * @description map测试
 * @date 2022/1/30 23:34
 */
public class MapMain {
	public static void main(String[] args){
		HashMap<String, String> map = new HashMap<>(4);
//		map.put("name", "李四");
		String absent = map.putIfAbsent("name", "张三");
		String absent2 = map.computeIfAbsent("name", key -> "赵丽颖");
		String absent3 = map.computeIfPresent("name", (key, value) -> "赵丽颖");
		System.out.println(absent);
		System.out.println(absent2);
		for (Map.Entry<String, String> stringStringEntry : map.entrySet()) {
			System.out.println(stringStringEntry.getKey() + "-----" + stringStringEntry.getValue());
		}
	}
}
