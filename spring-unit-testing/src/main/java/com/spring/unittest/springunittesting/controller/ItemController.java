package com.spring.unittest.springunittesting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.unittest.springunittesting.model.Item;
import com.spring.unittest.springunittesting.service.ItemDataService;

@RestController
public class ItemController {

	@Autowired
	private ItemDataService dataService;
	
	@GetMapping("/returnItem")
	public Item returnItem() {
		return new Item(1, "Karthik", "new", 2);
	}
	
	
	@GetMapping("/returnItemData")
	public Item returnItemData() {
		return dataService.returnData();
	}
	
	@GetMapping("/returnAllItemData")
	public List<Item> returnAllItemData() {
		return dataService.returnFromDb();
	}
	
}
