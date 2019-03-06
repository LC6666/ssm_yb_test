package com.iebm.ssm.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import com.iebm.ssm.util.OpenBrower;



/**
 * @author LC
 *	testng测试
 */
public class TestNGDemo1 {

	
	@BeforeClass
	public void BeforeClass(){
		System.out.println("@BeforeClass");
	}
	
	@BeforeGroups
	public void BeforeGroups(){
		System.out.println("@BeforeGroups");
	}
	
	@BeforeMethod
	public void BeforeMethod(){
		System.out.println("@BeforeGroups");
	}
	
	@BeforeSuite
	public void BeforeSuite(){
		System.out.println("@BeforeSuite");
	}
	
	@BeforeTest
	public void BeforeTest(){
		System.out.println("@BeforeTest");
	}
	
	
	@AfterClass
	public void AfterClass(){
		System.out.println("@AfterClass");
	}
	
	@AfterGroups
	public void AfterGroups(){
		System.out.println("@AfterGroups");
	}
	
	@AfterMethod
	public void AfterMethod(){
		System.out.println("@AfterMethod");
	}
	
	@AfterSuite
	public void AfterSuite(){
		System.out.println("@AfterSuite");
	}
	
	@AfterTest
	public void AfterTest(){
		System.out.println("@AfterTest");
//		OpenBrower.closeBrowser(driver);
	}
	
	@Test
	public void Test1(){
		System.out.println("@Test1");
	}

    @Test(dataProvider = "dataProvider")
    public void Test2(String str1,String str2){
        System.out.println("@Test2");
        System.out.println(str1+"====="+str2);
    }

    @DataProvider(name = "dataProvider")
    public static Object[][] DataProvider(){
        System.out.println("@DataProvider");
        return  new Object[][]{{"user","user"},{"admin","admin"}};
    }
	
	
	
	
	

}



