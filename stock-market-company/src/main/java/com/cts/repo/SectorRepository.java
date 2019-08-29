package com.cts.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.entity.Sector;

public interface SectorRepository extends JpaRepository<Sector, Integer>{
	public Sector findByName(String name);

}
