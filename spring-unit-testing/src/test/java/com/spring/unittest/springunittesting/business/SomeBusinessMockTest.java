package com.spring.unittest.springunittesting.business;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.spring.unittest.springunittesting.data.SomeDataService;

public class SomeBusinessMockTest {

	SomeBusinessImpl business = new SomeBusinessImpl();
	SomeDataService mockDate = mock(SomeDataService.class);

	//Executed before junit(assert)is executed
	@Before
	public void before() {
		business.setDataService(mockDate);
	}
	
	@Test
	public void calculate_sum() {
		when(mockDate.retrieveData()).thenReturn(new int[] {1,2,3});
		assertEquals(6, business.calculate_data());
	}
	
	
	@Test
	public void calculate_blank() {
		when(mockDate.retrieveData()).thenReturn(new int[] {});
		assertEquals(0, business.calculate_data());
	}

}
