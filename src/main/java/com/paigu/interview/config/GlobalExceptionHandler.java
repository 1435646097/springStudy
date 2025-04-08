package com.paigu.interview.config;

import cn.hutool.core.exceptions.ExceptionUtil;
import com.paigu.interview.utils.CommonResult;
import com.paigu.interview.utils.RequestJsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;

/**
 * 全局异常处理程序
 *
 * @author LiaoXM
 * @date 2021/10/27
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public CommonResult paramValidException(HttpServletRequest request, MethodArgumentNotValidException validException){
		String message = validException.getAllErrors().get(0).getDefaultMessage();
		log.warn("异常url：{},请求参数：{}，全局异常信息：{}", request.getRequestURI(), RequestJsonUtils.getRequestJsonString(request), ExceptionUtil.stacktraceToString(validException));
		return CommonResult.fail(message);
	}

	@ExceptionHandler(ConstraintViolationException.class)
	public CommonResult paramValidException(HttpServletRequest request, ConstraintViolationException validException){
		log.warn("异常url：{},请求参数：{}，全局异常信息：{}", request.getRequestURI(), RequestJsonUtils.getRequestJsonString(request), ExceptionUtil.stacktraceToString(validException));
		String message = validException.getLocalizedMessage();
		return CommonResult.fail(message);
	}

	@ExceptionHandler(Exception.class)
	public CommonResult paramValidException(HttpServletRequest request, Exception exception){
		log.error("异常url：{}-{},\r\n请求参数：{}，\r\n异常堆栈信息：{}", request.getRequestURI(), request.getMethod(), RequestJsonUtils.getRequestJsonString(request), ExceptionUtil.stacktraceToString(exception));
		return CommonResult.fail("系统错误,请联系系统管理员");
	}
}
