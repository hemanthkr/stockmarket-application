package com.cts;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class StockMarketCompanyApplication {

	private static final Logger LOGGER = LogManager.getLogger(StockMarketCompanyApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(StockMarketCompanyApplication.class, args);
	}
	
	LOGGER.info("Welcome to StockMarket Application.");

}
