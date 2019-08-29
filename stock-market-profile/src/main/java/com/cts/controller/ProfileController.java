package com.cts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.entity.Profile;
import com.cts.service.ConfirmEmailService;
import com.cts.service.ProfileService;

@RestController
@RequestMapping("/profile")
public class ProfileController {

	@Autowired
	ProfileService profileService;

	@Autowired
	ConfirmEmailService confirmEmailService;

	@PostMapping()
	public ResponseEntity<String> createAccount(@RequestBody Profile profile) {
		String result = profileService.register(profile);

		if (result.equalsIgnoreCase("Registered Successfully.")) {
			confirmEmailService.sendConfirmationEmail(profile);
			return new ResponseEntity<String>(result, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<String>(result, HttpStatus.FORBIDDEN);
		}
	}

	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody Profile profile) {
		String username = profile.getUsername();
		String password = profile.getPassword();
		String result = "";
		Profile profile2 = new Profile();
		profile2 = profileService.findProfile(username);

		if (profile2 != null) {
			if (profile2.getPassword().equals(password)) {
				if (profile2.getConfirmed().equals("yes")) {
					result = "The account login is successfull.";
					return new ResponseEntity<String>(result, HttpStatus.OK);
				} else {
					result = "The account email is not verified. Please Verify.";
					return new ResponseEntity<String>(result, HttpStatus.UNAUTHORIZED);
				}
			} else {
				result = "The account password is incorrect.";
				return new ResponseEntity<String>(result, HttpStatus.FORBIDDEN);
			}
		} else {
			result = "The account with username does not exist.";
			return new ResponseEntity<String>(result, HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/email/{id}")
	public ResponseEntity<String> confirmEmail(@PathVariable int id) {
		String result = confirmEmailService.verifyEmail(id);
		if (result.equals("Email verified")) {
			return new ResponseEntity<String>(result, HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<String>(result, HttpStatus.EXPECTATION_FAILED);
		}

	}

	@PutMapping()
	public ResponseEntity<String> updateAccount(@RequestBody Profile profile) {
		String result = profileService.updateProfile(profile);
		if (result.equals("Account Details have been updated.")) {
			return new ResponseEntity<String>(result, HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<String>(result, HttpStatus.EXPECTATION_FAILED);
		}
	}
}
