package com.cts.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class IpoDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "company_id", nullable = false, length = 20)
	private int companyId;
	
	@Column(name = "company_name", nullable = false, unique = true)
	private String companyName;
	
	@Column(name = "stock_ex", nullable = false, length = 30)
	private String stockExchange;
	
	@Column(name = "price_per_share", nullable = false, length = 50)
	private double pricePerShare;
	
	@Column(name = "total_share", nullable = false, length = 50)
	private long totalShare;
	
	@Column(name = "open_date_time", nullable = false, length = 50)
	private String openDateTime;
	
	@Column(length = 100)
	private String remarks;

	
	public IpoDetail() {
		super();
	}


	public IpoDetail(int id, int companyId, String companyName, String stockExchange, double pricePerShare,
			long totalShare, String openDateTime, String remarks) {
		super();
		this.id = id;
		this.companyId = companyId;
		this.companyName = companyName;
		this.stockExchange = stockExchange;
		this.pricePerShare = pricePerShare;
		this.totalShare = totalShare;
		this.openDateTime = openDateTime;
		this.remarks = remarks;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getCompanyId() {
		return companyId;
	}


	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}


	public String getCompanyName() {
		return companyName;
	}


	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}


	public String getStockExchange() {
		return stockExchange;
	}


	public void setStockExchange(String stockExchange) {
		this.stockExchange = stockExchange;
	}


	public double getPricePerShare() {
		return pricePerShare;
	}


	public void setPricePerShare(double pricePerShare) {
		this.pricePerShare = pricePerShare;
	}


	public long getTotalShare() {
		return totalShare;
	}


	public void setTotalShare(long totalShare) {
		this.totalShare = totalShare;
	}


	public String getOpenDateTime() {
		return openDateTime;
	}


	public void setOpenDateTime(String openDateTime) {
		this.openDateTime = openDateTime;
	}


	public String getRemarks() {
		return remarks;
	}


	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}


	@Override
	public String toString() {
		return "IpoDetail [id=" + id + ", companyId=" + companyId + ", companyName=" + companyName + ", stockExchange="
				+ stockExchange + ", pricePerShare=" + pricePerShare + ", totalShare=" + totalShare + ", openDateTime="
				+ openDateTime + ", remarks=" + remarks + "]";
	}


	
	
}
