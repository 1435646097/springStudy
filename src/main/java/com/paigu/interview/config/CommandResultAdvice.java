package com.paigu.interview.config;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.ReflectUtil;
import cn.hutool.core.util.StrUtil;
import com.paigu.interview.aop.hide.HideAnnotation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.lang.reflect.Field;
import java.util.Arrays;

/**
 * @author PaiGu
 * @description TODO
 * @date 2022/2/23 17:33
 */
@Slf4j
@RestControllerAdvice
public class CommandResultAdvice implements ResponseBodyAdvice<Object> {

	@Override
	public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass){
		log.info("methodParameter.getParameter():{}", methodParameter.getMethod());
		for (Field field : methodParameter.getParameterType().getDeclaredFields()) {
			if (field.isAnnotationPresent(HideAnnotation.class)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse){
		if (o != null) {
			Arrays.stream(o.getClass().getDeclaredFields())
			      .filter(field -> field.isAnnotationPresent(HideAnnotation.class))
			      .peek(field -> field.setAccessible(true))
			      .forEach(field -> {
				      try {
					      Object value = field.get(o);
					      this.isHideAnnotation(value);
//					      if (ObjectUtil.isNotEmpty(value) && value instanceof String) {
//						      String valueString = (String) value;
//						      HideAnnotation annotation = field.getAnnotation(HideAnnotation.class);
//						      field.set(o, StrUtil.hide(valueString, annotation.start(), annotation.end()));
//					      }
				      } catch (IllegalAccessException e) {
					      e.printStackTrace();
				      }
			      });
		}
		return o;
	}

	private void isHideAnnotation(Object obj){
		if (obj == null) {
			return;
		}
		if ((obj instanceof Iterable)) {
			Iterable<Object> iterable = (Iterable<Object>) obj;
			iterable.forEach(this::reflectionHideString);
			return;
		}
		reflectionHideString(obj);
	}

	private void reflectionHideString(Object obj){
		for (Field field : ReflectUtil.getFields(obj.getClass())) {
			field.setAccessible(true);
			Object value = null;
			try {
				value = field.get(obj);
				if (AnnotationUtils.findAnnotation(field, HideAnnotation.class) != null && ObjectUtil.isNotEmpty(value) && value instanceof String) {
					String valueString = (String) value;
					HideAnnotation annotation = field.getAnnotation(HideAnnotation.class);
					field.set(obj, StrUtil.hide(valueString, annotation.start(), annotation.end()));
					continue;
				}
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}

			if (value != null && AnnotationUtils.findAnnotation(field, HideAnnotation.class) != null) {
				this.reflectionHideString(value);
			}
		}
	}
}
