package com.example.cshand;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.cshand.mapper")
public class CsHandApplication {

	public static void main(String[] args) {
		SpringApplication.run(CsHandApplication.class, args);
	}

}
