package com.spring.unittest.springunittesting.controller;

import org.junit.Test;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

public class JsonPathTest {
	
	@Test
	public void testJson() {
		
		String json = "[" + "{id:1,name:karthik,desc:new,quantity:2},"
				+ "{id:2,name:karthik1,desc:new1,quantity:1},"
				+ "{id:3,name:karthik2,desc:new2,quantity:3}" + 
				"]";
		
		DocumentContext document =  JsonPath.parse(json);
		
		int length = document.read("$.length()");
		assertThat(length).isEqualTo(3);
		
		//Reads all object of id in json
		
		List<Integer> list = document.read("$..id");
		assertThat(list).contains(2);
		
		//Gives 1st element of JSON(Since it startes from 0 returns id:2)
		System.out.println(document.read("$.[1]").toString());
		
		//Returns 0th and 1st element(1 & 2)
		System.out.println(document.read("$.[0:1]").toString());
		
		//Returs json object with result name as karthik
		System.out.println(document.read("$.[?(@.name=='karthik')]").toString());
		
		
		
		
	}

}
