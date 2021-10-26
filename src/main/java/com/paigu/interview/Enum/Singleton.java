package com.paigu.interview.Enum;

public class Singleton {
	private static Singleton instance = new Singleton();

	private Singleton(){
		System.out.println("我初始化了");
	}

	public static   Singleton getInstance(){
		return instance;
	}
}
