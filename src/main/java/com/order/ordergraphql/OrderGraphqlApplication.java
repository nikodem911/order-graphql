package com.order.ordergraphql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class OrderGraphqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderGraphqlApplication.class, args);
	}

}
