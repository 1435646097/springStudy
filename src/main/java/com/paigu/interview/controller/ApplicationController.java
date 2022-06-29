package com.paigu.interview.controller;

import cn.hutool.core.annotation.AnnotationUtil;
import com.paigu.interview.aop.cache.RedisCacheAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.util.pattern.PathPattern;

import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

@RestController
public class ApplicationController {
    @Autowired
    private RequestMappingHandlerMapping requestMappingHandlerMapping;


    @GetMapping("/annotation")
    public Object test() {
        Set<String> anonymousUrls = new HashSet<>();
        for (Map.Entry<RequestMappingInfo, HandlerMethod> infoEntry : requestMappingHandlerMapping.getHandlerMethods().entrySet()) {
            HandlerMethod handlerMethod = infoEntry.getValue();
            RedisCacheAnnotation redisCacheAnnotation = Optional.ofNullable(AnnotationUtil.getAnnotation(handlerMethod.getMethod(), RedisCacheAnnotation.class))
                                                                .orElseGet(() -> AnnotationUtil.getAnnotation(handlerMethod.getMethod().getDeclaringClass(), RedisCacheAnnotation.class));
            if (redisCacheAnnotation != null) {
                RequestMappingInfo key = infoEntry.getKey();
                Set<PathPattern> patterns1 = key.getPathPatternsCondition()
                                                .getPatterns();
                Set<String> patterns = key
                        .getPatternsCondition()
                        .getPatterns();
                Set<RequestMethod> methods = key
                        .getMethodsCondition()
                        .getMethods();
                anonymousUrls.addAll(key
                        .getPatternsCondition()
                        .getPatterns());
            }
        }
        return anonymousUrls;
    }
}
