package com.cts.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.entity.StockPrice;

public interface StockPriceRepository extends JpaRepository<StockPrice, String>{

}
