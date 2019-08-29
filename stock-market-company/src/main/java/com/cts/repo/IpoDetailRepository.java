package com.cts.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.entity.IpoDetail;

public interface IpoDetailRepository extends JpaRepository<IpoDetail, Integer> {
	public IpoDetail findByCompanyNameAndStockExchange(String companyName, String stockExchange);

}
