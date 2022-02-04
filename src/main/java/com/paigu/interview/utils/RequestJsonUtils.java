package com.paigu.interview.utils;


import cn.hutool.core.util.StrUtil;
import org.springframework.web.util.ContentCachingRequestWrapper;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class RequestJsonUtils {

	/**
	 * 获取 request 中 json 字符串的内容
	 *
	 * @param request
	 * @return : <code>byte[]</code>
	 * @throws IOException
	 */
	public static String getRequestJsonString(HttpServletRequest request){
		try {
			String submitMethod = request.getMethod();
			// GET
			if ("GET".equals(submitMethod)) {
				if (request.getQueryString() == null) {
					return StrUtil.EMPTY;
				}
				return new String(request.getQueryString().getBytes("iso-8859-1"), "utf-8").replaceAll("%22", "\"");
				// POST PUT
			} else {
				return getRequestPostStr(request);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return StrUtil.EMPTY;
	}

	/**
	 * 描述:获取请求体内容
	 * <pre>
	 * 举例：
	 * </pre>
	 *
	 * @param request
	 * @return
	 * @throws IOException
	 */
	public static String getRequestPostStr(HttpServletRequest request) throws IOException{
		if (request instanceof ContentCachingRequestWrapper) {
			ContentCachingRequestWrapper requestWrapper = (ContentCachingRequestWrapper) request;
			return new String(requestWrapper.getContentAsByteArray(), requestWrapper.getCharacterEncoding());
		}
		return StrUtil.EMPTY;
	}
}
