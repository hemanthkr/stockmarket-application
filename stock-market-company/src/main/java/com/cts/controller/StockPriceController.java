package com.cts.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cts.service.StockPriceService;

@RestController
@RequestMapping("/stockprice")
public class StockPriceController {
	
	@Autowired
	StockPriceService stockPriceService;

	@PostMapping()
	public ResponseEntity<String> readExcelData(@RequestParam("file") MultipartFile excelFile) throws IOException {
		String result = stockPriceService.addStockPrice(excelFile);
		if (result.equals("Stockprice has been uploaded from file.")) {
			return new ResponseEntity<String>(result, HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<String>(result, HttpStatus.EXPECTATION_FAILED);
		}
	}
}
