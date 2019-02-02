package com.spring.unittest.springunittesting.jsonassert;

import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JsonAssertTest {
	
	String actual ="{\"id\":1,\"name\":\"Karthik\",\"desc\":\"new\",\"quantity\":2}";
	
	@Test
	public void jsonAssert_false() throws JSONException {
		
		String expected = "{\"id\":1,\"name\":\"Karthik\"}";
		//When false is passed exact output is not mandatory since it compares with available expected result
		JSONAssert.assertEquals(expected, actual, false);
	}
	
	
	@Test
	public void jsonAssert_true() throws JSONException {
		
		String expected = "{\"id\":1,\"name"
				+ ":\"Karthik\",\"desc\":\"new\",\"quantity\":2}";
		//When true is passed exact output is mandatory since it compares all data with available expected result
		JSONAssert.assertEquals(expected, actual, true);
	}
	
	
	@Test
	public void jsonAssert_NoEscapeCharacter() throws JSONException {
		
		//Escape characters is needed only when value is having spaces in between like name: karthik 2
		String expected = "{id:1,name:Karthik,desc:new,quantity:2}";
		
		JSONAssert.assertEquals(expected, actual, false);
	}

}
