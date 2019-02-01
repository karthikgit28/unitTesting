package com.spring.unittest.springunittesting.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class ItemControllerIT {

	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	public void contextTest() throws Exception {
		String response = this.restTemplate.getForObject("/returnAllItemData", String.class);
		
		JSONAssert.assertEquals("[{id:100},{id:101},{id:102}]", response, false);
		
	}
	
	
}
