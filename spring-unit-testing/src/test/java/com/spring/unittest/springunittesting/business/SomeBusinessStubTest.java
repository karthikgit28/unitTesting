package com.spring.unittest.springunittesting.business;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.spring.unittest.springunittesting.data.SomeDataService;

class SomeDataServiceStub implements SomeDataService{

	@Override
	public int[] retrieveData() {
		return new int[] {1,2,3};
	}
}

class SomeDataServiceBlankStub implements SomeDataService{

	@Override
	public int[] retrieveData() {
		return new int[] {};
	}
}


public class SomeBusinessStubTest {
	
	@Test
	public void stub_basic() {
		SomeBusinessImpl business = new SomeBusinessImpl();
		business.setDataService(new SomeDataServiceStub());
		int actualValue = business.calculate_data();
		int expected = 6;
		assertEquals(expected, actualValue);
	}
	
	@Test
	public void calculatestub_Blank() {
		SomeBusinessImpl business = new SomeBusinessImpl();
		business.setDataService(new SomeDataServiceBlankStub());
		int actualResult = business.calculate_data();
		int expected = 0;
		assertEquals(expected, actualResult);
	}
	
	

}
