package com.paigu.interview.entity;


/**
 * 人类
 *
 * @author PaiGu
 * @date 2021/11/09
 */
public class Person {
	private Person(){
	}

	private Person(Builder builder){
		this.name = builder.name;
		this.age = builder.age;
		this.gender = builder.gender;
		this.card = builder.card;
		this.phone = builder.phone;
	}

	private String name;
	private String age;
	private String gender;
	private String card;
	private String phone;

	public static class Builder {
		private String name;
		private String age;
		private String gender;
		private String card;
		private String phone;

		public Builder name(String name){
			this.name = name;
			return this;
		}

		public Builder age(String age){
			this.age = age;
			return this;
		}

		public Builder gender(String gender){
			this.gender = gender;
			return this;
		}

		public Builder card(String card){
			this.card = card;
			return this;
		}

		public Builder phone(String phone){
			this.phone = phone;
			return this;
		}

		public Person build(){
			return new Person(this);
		}
	}

	@Override
	public String toString(){
		return "Person{" +
				"name='" + name + '\'' +
				", age='" + age + '\'' +
				", gender='" + gender + '\'' +
				", card='" + card + '\'' +
				", phone='" + phone + '\'' +
				'}';
	}
}
