package com.cts.service;

import java.util.HashMap;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("zuul-api-gateway")
public interface CompanyServiceProxy {
	
	@GetMapping("/stock-market-company/company")
	public ResponseEntity<HashMap<String, Object>> getCompanyList();
	
}
