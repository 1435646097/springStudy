package com.paigu.interview.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author PaiGu
 * @description 人员信息
 * @date 2022/1/29 23:07
 */
@Data
@TableName("info")
public class Info {
	public Info(){
	}

	public Info(Long personId, String address, String school, String hobby){
		this.personId = personId;
		this.address = address;
		this.school = school;
		this.hobby = hobby;
	}

	@TableId(type = IdType.ASSIGN_ID)
	private Long id;
	private Long personId;
	/**
	 * 地址
	 */
	private String address;
	/**
	 * 学校
	 */
	private String school;
	/**
	 * 爱好
	 */
	private String hobby;
}
