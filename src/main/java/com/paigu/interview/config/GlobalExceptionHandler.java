package com.paigu.interview.config;

import com.paigu.interview.utils.CommonResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;

/**
 * 全局异常处理程序
 *
 * @author LiaoXM
 * @date 2021/10/27
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public CommonResult paramValidException (MethodArgumentNotValidException validException){
		String message = validException.getAllErrors()
		                               .get(0)
		                               .getDefaultMessage();
		return CommonResult.fail(message);
	}

	@ExceptionHandler(ConstraintViolationException.class)
	public CommonResult paramValidException(ConstraintViolationException validException){
		String message = validException.getLocalizedMessage();
		return CommonResult.fail(message);
	}
}
