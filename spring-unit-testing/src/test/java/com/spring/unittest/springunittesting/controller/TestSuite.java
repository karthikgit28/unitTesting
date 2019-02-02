package com.spring.unittest.springunittesting.controller;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({AssertJTest.class,HamcrestTest.class,ItemControllerIT.class,ItemControllerTest.class})
public class TestSuite {

}
