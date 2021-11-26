package com.paigu.interview.Validator.Book;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.paigu.interview.entity.Book;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


/**
 * 本验证器
 *
 * @author LiaoXM
 * @date 2021/11/24
 */
public class BookValidator implements ConstraintValidator<BookValid, Book> {

	@Override
	public boolean isValid(Book value, ConstraintValidatorContext context){
		if (StrUtil.isBlank(value.getBookName())) {
			return false;
		}
		return !ObjectUtil.isEmpty(value.getBookPrice()) && value.getBookPrice().longValue() > 0;
	}
}
