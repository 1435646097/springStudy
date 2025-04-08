package com.paigu.interview.filter;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingRequestWrapper;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author PaiGu
 * @description 用户异常时获取请求体
 * @date 2022/2/4 19:14
 */
@Component
public class GlobalFilter extends OncePerRequestFilter {
	@Override
	protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException{
		ContentCachingRequestWrapper wrappedRequest = new ContentCachingRequestWrapper(httpServletRequest);
		filterChain.doFilter(wrappedRequest, httpServletResponse);
	}
}
