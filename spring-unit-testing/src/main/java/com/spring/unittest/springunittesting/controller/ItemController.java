package com.spring.unittest.springunittesting.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.unittest.springunittesting.model.Item;

@RestController
public class ItemController {

	@GetMapping("/returnItem")
	public Item returnItem() {
		return new Item(1, "Karthik", "new", 2);
	}
	
}
