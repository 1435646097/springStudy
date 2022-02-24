package com.paigu.interview.aop.hide;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 隐藏注释(给标记的string字段中间加****)
 *
 * @author LiaoXM
 * @date 2022/02/24
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface HideAnnotation {

	/**
	 * 开始
	 *
	 * @return int
	 */
	int start() default 0;

	/**
	 * 结束
	 *
	 * @return int
	 */
	int end() default 0;
}
