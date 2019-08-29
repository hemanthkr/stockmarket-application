package com.cts.service;

import java.text.SimpleDateFormat;

import javax.transaction.Transactional;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cts.entity.StockPrice;
import com.cts.repo.StockPriceRepository;

@Service("stockPriceService")
public class StockPriceServiceImpl implements StockPriceService {

	@Autowired
	StockPriceRepository stockPriceRepository;

	@Override
	@Transactional
	public String addStockPrice(MultipartFile readExcelFile) {
		String timeStamp = null;
		XSSFWorkbook workbook;
		try {
			workbook = new XSSFWorkbook(readExcelFile.getInputStream());
			XSSFSheet sheet = workbook.getSheetAt(0);
			for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
				StockPrice stockPrice = new StockPrice();
				XSSFRow row = sheet.getRow(i);
				stockPrice.setCompanyCode((int) Double.parseDouble(row.getCell(0).toString()));
				stockPrice.setStockExchange(row.getCell(1).toString());
				stockPrice.setCurrentPrice(Double.parseDouble(String.valueOf(row.getCell(2))));
				stockPrice.setDate(row.getCell(3).toString());
				SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
				if (row.getCell(4).toString().contains("31-Dec-1899")) {
					timeStamp = format.format(row.getCell(4).getDateCellValue());
				}
				stockPrice.setTime(timeStamp);
				stockPriceRepository.save(stockPrice);
			}
			workbook.close();
			return "Stockprice has been uploaded from file.";
		} catch (Exception exception) {
			return "There was an error updating stockprice details.";
		}

	}
}
