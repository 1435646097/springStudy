package com.paigu.interview.Validator.IdCard;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 校验身份证是否有效
 *
 * @author LiaoXM
 * @date 2021/11/26
 */
@Documented
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
@Constraint(validatedBy = {IdCardValidator.class})
public @interface IdCardValid {
	String message() default "请填写正确的身份证";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
