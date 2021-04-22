package com.wallfacer5.giproject;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@MapperScan("com.wallfacer5.giproject.mapper")
@EnableTransactionManagement
@SpringBootApplication
public class GiProjectApplication {
	final Logger log = LoggerFactory.getLogger(getClass());

	public static void main(String[] args) {
		SpringApplication.run(GiProjectApplication.class, args);
	}
}
