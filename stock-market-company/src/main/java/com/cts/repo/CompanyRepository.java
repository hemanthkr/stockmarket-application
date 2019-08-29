package com.cts.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.entity.Company;

public interface CompanyRepository extends JpaRepository<Company, Integer> {
	public Company findById(int id);

	public Company findByName(String name);

}
