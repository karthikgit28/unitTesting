package com.spring.unittest.springunittesting.controller;

import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class AssertJTest {
	
	@Test
	public void testAssert() {
		List<Integer> list = Arrays.asList(12,13,14);
		
		assertThat(list).contains(12,13).hasSize(3)
		.allMatch(x -> x > 10)
		.allMatch(x -> x < 100);
		
		assertThat("").isEmpty();
		assertThat("ABCD").startsWith("ABC").endsWith("BCD");
	}

}
