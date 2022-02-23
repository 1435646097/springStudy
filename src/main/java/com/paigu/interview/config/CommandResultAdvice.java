package com.paigu.interview.config;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.paigu.interview.utils.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @author PaiGu
 * @description TODO
 * @date 2022/2/23 17:33
 */
@RestControllerAdvice
public class CommandResultAdvice implements ResponseBodyAdvice<Object> {
	@Autowired
	private ObjectMapper objectMapper;

	@Override
	public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass){
		return methodParameter.getParameterType() != CommonResult.class;
//				&& AnnotationUtils.findAnnotation(methodParameter.getParameter(),)
	}

	@Override
	public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse){
		if (o instanceof String) {
			return JSON.toJSONString(new CommonResult(0, "ok", o));
		}
		return o;
	}
}
