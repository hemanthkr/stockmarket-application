package com.cts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.cts.entity.Profile;
import com.cts.repo.ProfileRepository;

@Service("confirmationEmailService")
public class ConfirmEmailServiceImpl implements ConfirmEmailService {

	@Autowired
	JavaMailSender javaMailSender;

	@Autowired
	ProfileRepository profileRepository;

	@Override
	public String sendConfirmationEmail(Profile profile) {
		try {
			String text = "To confirm, please click the link below." + "\n\n" + "http://localhost:8080/profile/email/"
					+ profile.getId();
			SimpleMailMessage message = new SimpleMailMessage();
			message.setTo(profile.getEmail());
			message.setFrom("stocktest37@outlook.com");
			message.setSubject("Confirmation Email for Account");
			message.setText(text);
			javaMailSender.send(message);
		} catch (Exception exception) {
			return "Failed to send email";
		}
		return "Email Sent";

	}

	@Override
	public String verifyEmail(int id) {
		Profile profile = profileRepository.findById(id);
		if (profile.getConfirmed() == "no") {
			profile.setConfirmed("yes");
			profileRepository.save(profile);
		} else {
			return "Email already verified. Or the link is no longer valid";
		}
		return "Email verified";
	}

}
