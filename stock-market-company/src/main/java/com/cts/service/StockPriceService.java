package com.cts.service;

import org.springframework.web.multipart.MultipartFile;

public interface StockPriceService {

	public String addStockPrice(MultipartFile readExcelFile);
}
