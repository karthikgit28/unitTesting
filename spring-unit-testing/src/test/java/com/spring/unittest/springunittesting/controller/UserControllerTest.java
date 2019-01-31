package com.spring.unittest.springunittesting.controller;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {
	
	@Autowired
	private MockMvc mock;

	@Test
	public void testHello_Basic() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON);
		MvcResult result = mock.perform(request).andReturn();
		assertEquals("HelloWorld", result.getResponse().getContentAsString());
	}
	
	
	@Test
	public void testHello_BasicNoAssert() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON);
		MvcResult result = mock.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().string("HelloWorld"))
				.andReturn();
		//assertEquals("HelloWorld", result.getResponse().getContentAsString());
	}
	
}

