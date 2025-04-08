package com.paigu.interview.Validator.Book;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 书校验
 *
 * @author LiaoXM
 * @date 2021/11/24
 */
@Documented
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
@Constraint(validatedBy = {BookValidator.class})
public @interface BookValid {
	String message() default "请填写正确的书的信息";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
