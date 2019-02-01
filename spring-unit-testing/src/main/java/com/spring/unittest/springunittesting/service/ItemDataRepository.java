package com.spring.unittest.springunittesting.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.unittest.springunittesting.model.Item;

public interface ItemDataRepository extends JpaRepository<Item, Integer>{

}
