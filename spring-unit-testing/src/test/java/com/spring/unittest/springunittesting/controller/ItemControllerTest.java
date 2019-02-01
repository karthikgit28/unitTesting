package com.spring.unittest.springunittesting.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.mockito.Mockito.*;

import com.spring.unittest.springunittesting.model.Item;
import com.spring.unittest.springunittesting.service.ItemDataService;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Arrays;


@RunWith(SpringRunner.class)
@WebMvcTest(ItemController.class)
public class ItemControllerTest {

	@Autowired
	private MockMvc mock;
	
	@MockBean
	private ItemDataService dataService;
	
	@Test
	public void itemsDisplay() throws Exception{
		RequestBuilder request = MockMvcRequestBuilders.get("/returnItem").accept(MediaType.APPLICATION_JSON);
		
		mock.perform(request)
		.andExpect(status().isOk())
		.andExpect(content().json("{\"id\":1,\"name\":\"Karthik\",\"desc\":\"new\",\"quantity\":2}"))
		.andReturn();
	}
	
	
	@Test
	public void itemsDataService() throws Exception {
		
		when(dataService.returnData()).thenReturn(new Item(1, "karthik", "new", 2));
		
		RequestBuilder request = MockMvcRequestBuilders.get("/returnItemData").accept(MediaType.APPLICATION_JSON);
		
		mock.perform(request).andExpect(status().isOk())
		.andExpect(content().json("{id:1,name:karthik,desc:new,quantity:2}"))
		.andReturn();
		
	}
	
	@Test
	public void itemsDataServiceAllItem() throws Exception {
		
		when(dataService.returnFromDb()).thenReturn(Arrays.asList(new Item(1,"karthik","new",2),new Item(2,"karthik2","new2",3)));
		
		RequestBuilder request = MockMvcRequestBuilders.get("/returnAllItemData").accept(MediaType.APPLICATION_JSON);
		
		mock.perform(request).andExpect(status().isOk())
		.andExpect(content().json("[{id:1,name:karthik,desc:new,quantity:2},{id:2,name:karthik2,desc:new2,quantity:3}]"))
		.andReturn();
		
	}
	
	
}
