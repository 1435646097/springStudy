package com.paigu.interview.Enum;

public enum SingletonEnum {
	instance("美滋滋"),
	person("我是一个人"),
	student("学生党一枚");

	private String name;

	private SingletonEnum(String name){
		this.name = name;
	}


	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name = name;
	}

	public void doSomething(){
		System.out.println("hello world");
	}
}
