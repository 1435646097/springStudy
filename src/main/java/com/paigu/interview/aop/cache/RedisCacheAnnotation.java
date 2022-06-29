package com.paigu.interview.aop.cache;

import java.lang.annotation.*;

/**
 * redis缓存注释
 *
 * @author LiaoXM
 * @date 2021/09/14
 */
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface RedisCacheAnnotation {
    int expire() default 86400;
}
