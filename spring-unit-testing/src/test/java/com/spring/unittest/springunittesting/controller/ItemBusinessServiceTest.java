package com.spring.unittest.springunittesting.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import com.spring.unittest.springunittesting.model.Item;
import com.spring.unittest.springunittesting.service.ItemDataRepository;
import com.spring.unittest.springunittesting.service.ItemDataService;

@RunWith(MockitoJUnitRunner.class)
public class ItemBusinessServiceTest {
	
	@InjectMocks
	private ItemDataService dataService;
	
	@Mock
	private ItemDataRepository repository;
	
	
	@Test
	public void returnFromDb() {
		when(repository.findAll()).thenReturn(Arrays.asList(new Item(1,"karthik","new",2),new Item(2,"karthik2","new2",3)));
		List<Item> item = dataService.returnFromDb();
		
		assertEquals(4, item.get(0).getValue());
		assertEquals(9, item.get(1).getValue());
	}

}
