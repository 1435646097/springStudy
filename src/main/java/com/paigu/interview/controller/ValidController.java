package com.paigu.interview.controller;

import com.paigu.interview.Validator.Book.BookValid;
import com.paigu.interview.Validator.IdCard.IdCardValid;
import com.paigu.interview.entity.Book;
import com.paigu.interview.utils.CommonResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

/**
 * 验证的控制器
 *
 * @author LiaoXM
 * @date 2021/10/27
 */
@RestController
@RequestMapping("/valid")
@Validated
public class ValidController {

	@PostMapping("/requesttest")
	public CommonResult bankValid(@Valid @RequestBody Book book){
		return CommonResult.ok("保存成功");
	}

	@GetMapping("/gettest")
	public CommonResult getValid(@NotBlank(message = "姓名不能为空") String name){
		return CommonResult.ok("保存成功");
	}

	@PostMapping("/book-valid")
	public CommonResult boolValid(@BookValid @RequestBody Book book){
		return CommonResult.ok(book);
	}

	@GetMapping("/id-card")
	public CommonResult idCardValid(@IdCardValid String idCard){
		return CommonResult.ok("校验成功:" + idCard);
	}
}
