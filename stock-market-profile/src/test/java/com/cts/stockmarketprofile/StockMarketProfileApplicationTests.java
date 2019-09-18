package com.cts.stockmarketprofile;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cts.entity.Profile;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class StockMarketProfileApplicationTests {

	@Autowired
	private MockMvc mvc;

	@Test
	public void createAccountTest() throws Exception {
		mvc.perform(MockMvcRequestBuilders.post("/profile")
				.content(asJsonString(new Profile("hemanth", "hemanth", "admin", "email4@mail.com", "78946513", "yes")))
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated());

	}
	
	@Test
	public void loginAccountTest() throws Exception {
		mvc.perform(MockMvcRequestBuilders.post("/profile/login")
				.content(asJsonString(new Profile("hemanth", "hemanth", "", "", "", "")))
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());

	}
	
	
	

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
