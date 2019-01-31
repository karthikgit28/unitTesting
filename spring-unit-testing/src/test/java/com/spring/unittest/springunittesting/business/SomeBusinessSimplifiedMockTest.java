package com.spring.unittest.springunittesting.business;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.spring.unittest.springunittesting.data.SomeDataService;

@RunWith(MockitoJUnitRunner.class)
public class SomeBusinessSimplifiedMockTest {
	
	@InjectMocks
	SomeBusinessImpl business;
	
	@Mock
	SomeDataService mockDate;
	
	@Mock
	List<String> list;
	
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
	
	@Test
	public void listSize() {
		when(list.size()).thenReturn(5);
		assertEquals(5, list.size());
	}
	
	
	@Test
	public void listMultipleSize() {
		//It calls 2 times
		when(list.size()).thenReturn(5).thenReturn(10);
		assertEquals(5, list.size());
		assertEquals(10, list.size());
	}
	
	
	@Test
	public void listValue() {
		when(list.get(0)).thenReturn("karthik");
		assertEquals("karthik", list.get(0));
		assertEquals(null, list.get(1));
		
	}
	
	
	@Test
	public void listGeneric() {
		when(list.get(anyInt())).thenReturn("karthik");
		assertEquals("karthik", list.get(0));
		assertEquals("karthik", list.get(1));
	}
	
	
	@Test
	public void verification() {
		
		String value1 = list.get(0);
		String value2 = list.get(1);
		
		verify(list).get(0);
		verify(list, times(2)).get(anyInt());
		verify(list, atLeastOnce()).get(anyInt());
		verify(list, atLeast(1)).get(anyInt());
		verify(list, atMost(2)).get(anyInt());
		verify(list, never()).get(2);
		
	}
	
	
	@Test
	public void captureArgument() {
		list.add("Karthik");
		
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		verify(list).add(captor.capture());
		
		assertEquals("Karthik", captor.getValue());
		
	}
	
	
	@Test
	public void captureMultipleArgument() {
		list.add("Karthik1");
		list.add("Karthik2");
		
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		//By default verify will check whether 1 timecall is made since two times its made need to specify times
		verify(list,times(2)).add(captor.capture());
		
		List<String> values = captor.getAllValues();
		assertEquals("Karthik1", values.get(0));
		assertEquals("Karthik2", values.get(1));
		
	}
	
	
	@Test
	public void mocking() {
		
		ArrayList<String> list = mock(ArrayList.class);
		System.out.println(list.get(0));
		System.out.println(list.size());
		list.add("test1");
		list.add("test2");
		System.out.println(list.size());
		
		when(list.size()).thenReturn(5);
		System.out.println(list.size());
		
	}
	
	
	@Test
	public void spying() {
		
		//Original behaviour of mock is returned
		ArrayList<String> list = spy(ArrayList.class);
		list.add("karthik");
		System.out.println(list.get(0));
		System.out.println(list.size());
		list.add("test1");
		list.add("test2");
		System.out.println(list.size());
		
		when(list.size()).thenReturn(5);
		System.out.println(list.size());
		
	}
	
	
	

}
