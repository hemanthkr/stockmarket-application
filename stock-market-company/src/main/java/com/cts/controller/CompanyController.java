package com.cts.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.entity.Company;
import com.cts.service.CompanyService;

@RestController
@RequestMapping("/company")
public class CompanyController {

	@Autowired
	CompanyService companyService;

	@GetMapping()
	public ResponseEntity<HashMap<String, Object>> listCompany() {
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		List<Company> arrayList = companyService.getCompany();
		HttpStatus httpStatus;
		if (arrayList.size() == 0) {
			httpStatus = HttpStatus.NOT_FOUND;
			hashMap.put("message", "No records found.");
		} else {
			hashMap.put("result", arrayList);
			httpStatus = HttpStatus.OK;
		}
		return new ResponseEntity<HashMap<String, Object>>(hashMap, httpStatus);
	}

	@PostMapping()
	public ResponseEntity<String> saveCompany(@RequestBody Company company) {
		String result = companyService.addCompany(company);
		if (result.equalsIgnoreCase("Registered Successfully.")) {
			return new ResponseEntity<String>(result, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<String>(result, HttpStatus.FORBIDDEN);
		}
	}

	@PostMapping("/status")
	public ResponseEntity<String> updateCompanyStatus(@RequestBody Company company) {
		String result = companyService.companyStatus(company);

		if (result.equalsIgnoreCase("Unsuccessfull. The company does not exist.")) {
			return new ResponseEntity<String>(result, HttpStatus.FORBIDDEN);
		} else {
			return new ResponseEntity<String>(result, HttpStatus.ACCEPTED);
		}
	}

	@PutMapping()
	public ResponseEntity<String> updateCompanyDetails(@RequestBody Company company) {
		String result = companyService.updateCompany(company);
		if (result.equals("Company details were updated.")) {
			return new ResponseEntity<String>(result, HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<String>(result, HttpStatus.EXPECTATION_FAILED);
		}

	}

	

}
