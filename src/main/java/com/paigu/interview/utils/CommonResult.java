package com.paigu.interview.utils;

import com.paigu.interview.aop.hide.HideAnnotation;
import lombok.Data;

/**
 * 通用返回结果
 *
 * @author LiaoXM
 * @date 2021/10/26
 */
@Data
public class CommonResult {
	private Integer state;
	private String msg;
	@HideAnnotation
	private Object data;

	public CommonResult(String msg){
		this(null, msg);
	}

	public CommonResult(Integer state, String msg){
		this(state, msg, null);
	}

	public CommonResult(Integer state, String msg, Object data){
		this.state = state;
		this.msg = msg;
		this.data = data;
	}

	public static CommonResult fail(){
		return new CommonResult(0, "");
	}

	public static CommonResult fail(String msg){
		return new CommonResult(0, msg);
	}

	public static CommonResult ok(){
		return new CommonResult(1, "ok", null);
	}

	public static CommonResult ok(String msg){
		return new CommonResult(1, msg, null);
	}

	public static CommonResult ok(Object data){
		return new CommonResult(1, "", data);
	}
}
