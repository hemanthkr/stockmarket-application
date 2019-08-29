package com.cts.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.entity.StockExchange;

public interface StockExchangeRepository extends JpaRepository<StockExchange, Integer>{

}
