package com.paigu.interview.config;

import com.paigu.interview.utils.CommonResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理程序
 *
 * @author LiaoXM
 * @date 2021/10/27
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public CommonResult validException(MethodArgumentNotValidException validException){
		String message = validException.getAllErrors()
		                                      .get(0)
		                                      .getDefaultMessage();
		return CommonResult.fail(message);
	}
}
