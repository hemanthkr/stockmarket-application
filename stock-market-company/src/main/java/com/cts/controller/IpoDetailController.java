package com.cts.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.entity.IpoDetail;
import com.cts.service.IpoDetailService;

@CrossOrigin
@RestController
@RequestMapping("/ipo")
public class IpoDetailController {
	
	@Autowired
	IpoDetailService ipoDetailService;
	
	@PostMapping()
	public ResponseEntity<String> updateIpo(@RequestBody IpoDetail detail) {
		String result = ipoDetailService.updateIpo(detail);
		if (result.equals("Unsuccessfull.")) {
			return new ResponseEntity<String>(result, HttpStatus.EXPECTATION_FAILED);
		} else {
			return new ResponseEntity<String>(result, HttpStatus.ACCEPTED);
		}
	}
	
	@GetMapping()
	public ResponseEntity<HashMap<String, Object>> getIpoDetails(){
		List<IpoDetail> arrayList = new ArrayList<IpoDetail>();
		arrayList = ipoDetailService.fetchIpoDetail();
		String result = "";
		HttpStatus httpStatus;
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		if(arrayList.size() == 0) {
			hashMap.put(result, "No list was present.");
			httpStatus = HttpStatus.NOT_FOUND;
		} else {
			hashMap.put("result", arrayList);
			httpStatus = HttpStatus.ACCEPTED;
		}
		return new ResponseEntity<HashMap<String,Object>>(hashMap, httpStatus);
	}
}
