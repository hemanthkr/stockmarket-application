package com.cts.service;

import com.cts.entity.Profile;

public interface ProfileService {
	
	public String register(Profile profile);
	public Profile findProfile(String username);
	public String updateProfile(Profile profile);
}
