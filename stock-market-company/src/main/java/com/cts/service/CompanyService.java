package com.cts.service;

import java.util.List;

import com.cts.entity.Company;

public interface CompanyService {

	public List<Company> getCompany();

	public String addCompany(Company company);

	public String companyStatus(Company company);

	public String updateCompany(Company company);

}
