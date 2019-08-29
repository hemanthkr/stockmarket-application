package com.cts.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.service.CompanyServiceProxy;

@RestController
@RequestMapping("/company")
public class CompanyControllerProxy {
	
	@Autowired
	CompanyServiceProxy companyServiceProxy;
	
	@GetMapping()
	public ResponseEntity<HashMap<String, Object>> getAllCompany(){
		return companyServiceProxy.getCompanyList();
	}
	
}
