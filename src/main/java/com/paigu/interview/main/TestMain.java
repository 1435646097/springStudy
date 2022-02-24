package com.paigu.interview.main;

import cn.hutool.core.util.StrUtil;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class TestMain {
	static Integer num = 0;
	public static void main(String[] args) throws InterruptedException{
		Stream<Integer> integerStream = Stream.of(2, 3, 4, 5, 4, 3, 3);
		Optional<Integer> max = integerStream.max(Integer::compareTo);
		System.out.println(max.get());
//		long count = integerStream.count();
//		Optional<Integer> first = integerStream.findFirst();
//		System.out.println(count);
//		first.ifPresent(System.out::println);
//		System.out.println(integer);
//		Person person = new Person.Builder().name("我的尼玛")
//		                                    .gender("男")
//		                                    .card("10086")
//		                                    .phone("110")
//		                                    .age("20")
//		                                    .build();
//		System.out.println(person);
		List<Integer> list = new ArrayList<>();
		for (Integer integer : list) {
			System.out.println(integer);
		}
		String str1 = "我的后勤保障组";
//		String str2 = "感控督导员";
		System.out.println(StrUtil.replace(str1, "后勤保障组", "感控督导员"));
//		CompletableFuture.allOf()
//		CompletableFuture.runAsync()
//		AtomicInteger atomicInteger = new AtomicInteger();
//		TimeUnit.SECONDS.sleep(1);
		double a = 0.1;
		double b = 0.2;
		System.out.println(a + b);
		BigDecimal bigDecimal = BigDecimal.valueOf(0.1).add(BigDecimal.valueOf(0.256));
//		bigDecimal.co
//		bigDecimal.round()
//		DecimalFormat decimalFormat = new DecimalFormat("#.##");
//		decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
		System.out.println();
//		$2a$10$Tpq9rseG8UZfv.xmHYfeZODmk10Q28yBObYyg0WpCOcVaEia28gtW
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		String encode = encoder.encode("123456");
		System.out.println(encode);
		System.out.println(encoder.matches("123456", "$2a$10$AAIo/hQr9UBrqLW5WeAGweMvJHqcVxdiEKJ8XQkZUN4xDvkS07dr."));
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {
				if(j<=i){
					sb.append(j).append("*").append(i).append("=").append(i*j).append("\t");
				}
			}
			sb.append("\r\n");
		}
		System.out.println(sb);
	}
}
