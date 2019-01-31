package com.spring.unittest.springunittesting.business;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SomeBusinessTest {
	
	@Test
	public void calculateSum_basic() {
		SomeBusinessImpl business = new SomeBusinessImpl();
		int actualResult = business.calculate(new int[] {1,2,3});
		int expected = 6;
		assertEquals(expected, actualResult);
	}
	
	
	@Test
	public void calculateSum_Blank() {
		SomeBusinessImpl business = new SomeBusinessImpl();
		int actualResult = business.calculate(new int[] {});
		int expected = 0;
		assertEquals(expected, actualResult);
	}
	
	
	@Test
	public void calculateSum_Fail() {
		SomeBusinessImpl business = new SomeBusinessImpl();
		int actualResult = business.calculate(new int[] {1,1,1});
		int expected = 6;
		assertEquals(expected, actualResult);
	}

}
