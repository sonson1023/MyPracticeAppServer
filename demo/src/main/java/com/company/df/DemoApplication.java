package com.company.df;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;


@SpringBootApplication
//따로 하는게 맞지만.
//암호화 떄문에 CommandLineRunner 추가.
public class DemoApplication implements CommandLineRunner 
 {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

        System.out.println("=========== Server Start ===========");
	}

	
	@Override
	   public void run(String... args) throws Exception {
			StandardPBEStringEncryptor pbeEnc = new StandardPBEStringEncryptor();
			pbeEnc.setAlgorithm("PBEWithMD5AndDES");
			pbeEnc.setPassword("test"); //2번 설정의 암호화 키를 입력
			
			String enc = pbeEnc.encrypt("springuser"); //암호화 할 내용
			System.out.println("enc = " + enc); //암호화 한 내용을 출력
			
			//테스트용 복호화
			String des = pbeEnc.decrypt(enc);
			System.out.println("des = " + des);
			
			 enc = pbeEnc.encrypt("ThePassword"); //암호화 할 내용
			System.out.println("enc = " + enc); //암호화 한 내용을 출력
			
			//테스트용 복호화
			 des = pbeEnc.decrypt(enc);
			System.out.println("des = " + des);
	   }
}
