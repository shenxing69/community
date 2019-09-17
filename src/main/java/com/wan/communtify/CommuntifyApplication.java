package com.wan.communtify;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.wan.communtify.mapper")
public class CommuntifyApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommuntifyApplication.class, args);
	}

}
