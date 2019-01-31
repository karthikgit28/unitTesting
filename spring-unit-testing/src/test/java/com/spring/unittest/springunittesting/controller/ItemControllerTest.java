package com.spring.unittest.springunittesting.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@WebMvcTest(ItemController.class)
public class ItemControllerTest {

	@Autowired
	private MockMvc mock;
	
	@Test
	public void itemsDisplay() throws Exception{
		RequestBuilder request = MockMvcRequestBuilders.get("/returnItem").accept(MediaType.APPLICATION_JSON);
		
		mock.perform(request)
		.andExpect(status().isOk())
		.andExpect(content().json("{\"id\":1,\"name\":\"Karthik\",\"desc\":\"new\",\"quantity\":2}"))
		.andReturn();
	}
	
}
