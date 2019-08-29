package com.cts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableEurekaClient
@SpringBootApplication
@EnableFeignClients("com.cts.service")
public class StockMarketProfileApplication{

	public static void main(String[] args) {
		SpringApplication.run(StockMarketProfileApplication.class, args);
	}

}
