package com.anwar.salesinventory;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.anwar.salesinventory.mapper")
@SpringBootApplication
public class SalesInventorySystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalesInventorySystemApplication.class, args);
	}

}
