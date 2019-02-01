package com.spring.unittest.springunittesting.controller;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;


import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class HamcrestTest {
	
	@Test
	public void testHamcrest() {
		List<Integer> list = Arrays.asList(12,13,14);
		
		assertThat(list, hasSize(3));
		assertThat(list, hasItems(12,13));
		assertThat(list, everyItem(greaterThan(10)));
		assertThat(list, everyItem(lessThan(100)));
		
		assertThat("", isEmptyString());
		assertThat("ABCDE", startsWith("ABC"));
		assertThat("ABCDE", containsString("ABC"));
		
		
	}

}
