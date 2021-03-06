package com.qindy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.qindy.dao")
@EnableAutoConfiguration
@SpringBootApplication
public class QinApplication {

	public static void main(String[] args) {
		SpringApplication.run(QinApplication.class, args);
	}
}
