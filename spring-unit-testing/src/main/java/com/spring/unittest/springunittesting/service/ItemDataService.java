package com.spring.unittest.springunittesting.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.unittest.springunittesting.model.Item;

@Component
public class ItemDataService {
	
	@Autowired
	private ItemDataRepository repository;

	public Item returnData() {
		return new Item(2, "karthik1", "Testdesc", 3);
	}
	
	
	public List<Item> returnFromDb(){
		List<Item> item = repository.findAll();
		for(Item items: item) {
			items.setValue(items.getQuantity() * items.getQuantity());
		}
		return item;
	}
	
	public Item saveToDb(Item item){
		return repository.save(item);
	}
	
}
