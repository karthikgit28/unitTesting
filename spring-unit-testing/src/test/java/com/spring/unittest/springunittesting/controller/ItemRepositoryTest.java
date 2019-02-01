package com.spring.unittest.springunittesting.controller;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.spring.unittest.springunittesting.model.Item;
import com.spring.unittest.springunittesting.service.ItemDataRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ItemRepositoryTest {

	@Autowired
	private ItemDataRepository repository;
	
	
	@Test
	public void testdataLayer() {
		List<Item> items = repository.findAll();
		assertEquals(3, items.size());
	}
	
}
