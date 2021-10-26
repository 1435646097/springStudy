package com.paigu.interview;

import com.paigu.interview.utils.RsaUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.security.NoSuchAlgorithmException;

@SpringBootTest
public class RsaTest {
	private String privateKey = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAIxib1BVgG5Ho3xUHKIoQ5RCKJ5+jkglqqCycihPVAR+62HXtdaqQ7atLwoHWKHzffSIdG2q65ZtApYgKnl8i7qdgxmCOPaEkGSsRTyFXP6uAHZs+5YKPHZpt6ApJgdFaxsKud+SynIwzecieiujzQzuGYFhHG29LauAGntgbyc5AgMBAAECgYB3Ya4vrsZNAfbxX8YJ0BvIFIreXdk5WW7EwXt69BsKx7P7vKkSKDD1RElgSecBskNGlFQOfu9hOMqeSDRWo6degD8iJGSFGafkk9ud7SWni5iBKvjRtvXpEHiWvbManzaz3uB7sodSv3BW+3SvzpBygxquCfz8Z5Nx/MlQQrqFUQJBAODDfG8CDV9wbwJexF+LxW69Q5zrPF5Z77TEUwnC35Ett+jRRCBnopGoS7NTnVaTlDwUZIEJ9l+XOOxRUoFyAYMCQQCf5PTLAyB+rGXDLneqn7jKjYjlS2/QC8Gs4HQZ2S+YFdU+cPbvCYvGAugXCDlv7l+ZW2iXCpdjZPqBI8YOsUOTAkEA1fUBFOMNO9bZtZXktVdmP/5myI+dTeurJZblvRsGmzq8ISJkCbzdom5kcXadBfdCWtbGvZdwMprPkxXuxk5yZQJAeYY4jzuXLO+2gDwG84Vlm30q+Kr3FnZ5Av2tACBTzhF5+3U8GL12oE6BO1Ai53GS8ynIOlPwb7jFs/UOiQgtRQJBAKsAIbvUPlTbK9YCIKNTKSFDuJBdZDRHqwBevDVXCWfc/mPC3s8XCS9esDbAzQq0XA1JABlS69HBryQbpidnfMM=";
	private String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCMYm9QVYBuR6N8VByiKEOUQiiefo5IJaqgsnIoT1QEfuth17XWqkO2rS8KB1ih8330iHRtquuWbQKWICp5fIu6nYMZgjj2hJBkrEU8hVz+rgB2bPuWCjx2abegKSYHRWsbCrnfkspyMM3nInoro80M7hmBYRxtvS2rgBp7YG8nOQIDAQAB";

	@Test
	void rsaDesc() throws Exception{
		String str = "我我我";
		String encryptStr = RsaUtils.encryptByPublicKey(publicKey, str);
		System.out.println(encryptStr);
		String decryptStr = RsaUtils.decryptByPrivateKey(privateKey, encryptStr);
		System.out.println(decryptStr);
	}

	@Test
	void generatorPair() throws NoSuchAlgorithmException{
		RsaUtils.RSAKeyPair rsaKeyPair = RsaUtils.generateKeyPair();
		System.out.println(rsaKeyPair.getPrivateKey());
		System.out.println(rsaKeyPair.getPublicKey());
	}
}
