package com.paigu.interview.aop.cache;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * redis缓存注释
 *
 * @author LiaoXM
 * @date 2021/09/14
 */
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface redisCacheAnnotation {
    int expire() default 86400;
}
