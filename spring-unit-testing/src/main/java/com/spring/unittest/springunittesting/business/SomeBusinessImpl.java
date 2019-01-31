package com.spring.unittest.springunittesting.business;

import com.spring.unittest.springunittesting.data.SomeDataService;

public class SomeBusinessImpl {
	
	private SomeDataService dataService;
	
	public void setDataService(SomeDataService dataService) {
		this.dataService = dataService;
	}


	public int calculate(int[] data) {
		int sum = 0;
		for(int value:data) {
			sum+=value;
		}
		return sum;
	}
	
	
	public int calculate_data() {
		int sum = 0;
		int data[] = dataService.retrieveData();
		for(int value:data) {
			sum+=value;
		}
		return sum;
	}

}
