package com.iebm.ssm.test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TestNGDemo {
	
	private String test_str="";
	
  @Test(dataProvider = "dp",priority=0)
  public void f(Integer n, String s) {
	  test_str = test_str+">Test0";
	  System.out.println("Test0");
//	  System.out.println("BeforeSuite>BeforeTest>BeforeClass>BeforeMethod>Test>AfterMethod>AfterClass>AfterTest>AfterSuite");
  }
  
  @Test(priority=1)
  @Parameters("testparameters")
  public void f2(@Optional("no parameters")String testparameters) {
	  test_str = test_str+">Test1";
//	  System.out.println(testparameters);
	  System.out.println("Test1");
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  test_str = test_str+">beforeMethod";
	  System.out.println("beforeMethod");
  }

  @AfterMethod
  public void afterMethod() {
	  test_str = test_str+">afterMethod";
	  System.out.println("afterMethod");
  }


  @DataProvider
  public Object[][] dp() {
	  test_str = test_str+">DataProvider";
	  System.out.println("DataProvider");
    return new Object[][] {
      new Object[] { 1, "a" },
      new Object[] { 2, "b" },
    };
  }
  @BeforeClass
  public void beforeClass() {
	  test_str = test_str+">beforeClass";
	  System.out.println("beforeClass");
  }

  @AfterClass
  public void afterClass() {
	  test_str = test_str+">afterClass";
	  System.out.println("afterClass");
  }

  @BeforeTest
  public void beforeTest() {
	  test_str = test_str+">beforeTest";
	  System.out.println("beforeTest");
  }

  @AfterTest
  public void afterTest() {
	  test_str = test_str+">afterTest";
	  System.out.println("afterTest");
  }

  @BeforeSuite
  public void beforeSuite() {
	  test_str = test_str+">beforeSuite";
	  System.out.println("beforeSuite");
  }

  @AfterSuite
  public void afterSuite() {
	  test_str = test_str+">afterSuite";
	  System.out.println("afterSuite");
	  System.out.println(test_str);
  }

}
