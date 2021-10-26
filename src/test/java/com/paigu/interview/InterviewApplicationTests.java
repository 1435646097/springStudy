package com.paigu.interview;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SpringBootTest
class InterviewApplicationTests {

	@Test
	void contextLoads(){
		Pattern NUMBERS = Pattern.compile("^(\\d+)(\\.\\d{1})?$");
		Matcher matcher = NUMBERS.matcher("36.5");
		System.out.println(matcher.matches());
	}
}
