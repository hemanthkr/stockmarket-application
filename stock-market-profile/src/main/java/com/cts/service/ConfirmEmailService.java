package com.cts.service;

import com.cts.entity.Profile;

public interface ConfirmEmailService {
	public String sendConfirmationEmail(Profile profile) ;
	public String verifyEmail(int id);
}
