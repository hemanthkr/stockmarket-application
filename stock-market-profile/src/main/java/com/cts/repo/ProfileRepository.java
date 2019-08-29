package com.cts.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.entity.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Integer>{
	
	public Profile findById(int id);
	public Profile findByUsername(String username);
	public Profile findByUsernameOrEmailOrMobile(String username, String email, String mobile);
	
}
