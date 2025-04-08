package com.paigu.interview.Validator.IdCard;

import cn.hutool.core.util.IdcardUtil;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * 身份证验证器
 *
 * @author LiaoXM
 * @date 2021/11/26
 */
public class IdCardValidator implements ConstraintValidator<IdCardValid, String> {
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context){
		return IdcardUtil.isValidCard(value);
	}
}
