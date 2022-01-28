package com.paigu.interview.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 人类
 *
 * @author PaiGu
 * @date 2021/11/09
 */
@TableName("person")
@Data
public class Person {
	public Person(){
	}

	private Person(Builder builder){
		this.name = builder.name;
		this.age = builder.age;
		this.gender = builder.gender;
		this.card = builder.card;
		this.phone = builder.phone;
	}
	@TableId(type = IdType.ASSIGN_ID)
	private Long id;
	private String name;
	private Integer age;
	private Character gender;
	private String card;
	private String phone;

	public static class Builder {
		private String name;
		private Integer age;
		private Character gender;
		private String card;
		private String phone;

		public Builder name(String name){
			this.name = name;
			return this;
		}

		public Builder age(Integer age){
			this.age = age;
			return this;
		}

		public Builder gender(Character gender){
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
