package com.cts.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.entity.Profile;
import com.cts.repo.ProfileRepository;

@Service("profileService")
public class ProfileServiceImpl implements ProfileService {

	@Autowired
	ProfileRepository profileRepository;

	@Override
	@Transactional
	public String register(Profile profile) {
		String result = "";
		try {
			profileRepository.save(profile);
			result = "Registered Successfully.";
		} catch (Exception exception) {
			result = "This account already exists.";
		}
		return result;
	}

	@Override
	@Transactional
	public Profile findProfile(String username) {
		Profile profile = new Profile();
		profile = profileRepository.findByUsername(username);
		return profile;
	}

	@Override
	@Transactional
	public String updateProfile(Profile profile) {
		String result = "";
		try {
			Profile profile2 = profileRepository.findById(profile.getId());
			profile2.setMobile(profile.getMobile());
			profile2.setPassword(profile.getPassword());
			profileRepository.save(profile2);
			result = "Account Details have been updated.";
		} catch (Exception exception) {
			result = "An error occured during updation.";
		}
		return result;
	}

}
