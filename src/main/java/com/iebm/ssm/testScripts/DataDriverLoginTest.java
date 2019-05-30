package com.iebm.ssm.testScripts;


import com.iebm.ssm.appModules.Login_Action;
import com.iebm.ssm.util.*;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;

/*
 *TODO
 * 数据驱动测试
 *LC
 *下午6:19:28
*/


public class DataDriverLoginTest {


	@DataProvider(name="loginInfo")
	public static Object[][] getloginInfo(){
		Object[][] revalue = new Object[][]{{"ssm","83881021"},{"1001","666666"}};
		return  revalue;
	}

	@DataProvider(name="loginData")
	public static Object[][] getloginData() throws IOException {
		return TestDataDrivenByCSVFile.getTestData("./resource/login_data.csv");
	}

	@DataProvider(name="loginDatafromExcel")
	public static Object[][] getloginDataByExcel() throws IOException {
		return TestDataDrivenByExcelFile.getDataFromXlxs("./resource/", "login_data.xls", "login_data");
	}

	@DataProvider(name="loginDatafromExcel2")
	public static Object[][] getloginDataByExcel2() throws IOException {
		return TestDataDrivenByExcelFile.getDataFromXlxs("./resource/", "login_data.xlsx", "login_data");
	}

	@DataProvider(name="loginDatafromMysql")
	public static Object[][] getloignDataByMysql() throws ClassNotFoundException {
		return TestDataDrivenByMysql.getTestData("login_test");
	}



	@Test(testName = "dataDriverLogin",dataProvider = "loginInfo",priority = 1)
	public void dataDriverLogin(String loginid,String password) throws Exception{
		Log.info("使用DataDriver测试");
		Login_Action.execute(loginid, password);
		Thread.sleep(3000);
		Assert.assertTrue(Constant.driver.getPageSource().contains("退出系统"));
	}


	@Test(testName = "dataDriverLoginFromCSV",dataProvider = "loginData",priority = 2)
	public void dataDriverLoginFromCSV(String loginid,String password) throws Exception{
		Log.info("使用DataDriver测试");
		Login_Action.execute(loginid, password);
		Thread.sleep(3000);
		Assert.assertTrue(Constant.driver.getPageSource().contains("退出系统"));
	}

	@Test(testName = "dataDriverLoginFromExcel",dataProvider = "loginDatafromExcel",priority = 3)
	public void dataDriverLoginFromExcel(String loginid,String password) throws Exception{
		Log.info("使用DataDriver测试");
		Login_Action.execute(loginid, password);
		Thread.sleep(3000);
		Assert.assertTrue(Constant.driver.getPageSource().contains("退出系统"));
	}

	@Test(testName = "dataDriverLoginFromExcel2",dataProvider = "loginDatafromExcel2",priority = 4)
	public void dataDriverLoginFromExcel2(String loginid,String password) throws Exception{
		Log.info("使用DataDriver测试");
		Login_Action.execute(loginid, password);
		Thread.sleep(3000);
		Assert.assertTrue(Constant.driver.getPageSource().contains("退出系统"));
	}

	@Test(testName = "dataDriverLoginFromMysql",dataProvider = "loginDatafromMysql",priority = 5)
	public void dataDriverLoginFromMysql(String id,String loginid,String password) throws Exception{
		Log.info("使用DataDriver测试");
		Login_Action.execute(loginid, password);
		Thread.sleep(3000);
		Assert.assertTrue(Constant.driver.getPageSource().contains("退出系统"));
	}

	@Test(testName = "guestLogin")
	public void guestLogin() throws Exception{
		Log.info("调用Login_Action.execute");
		Login_Action.execute(Constant.loginUsername, Constant.loginPassword);
		Thread.sleep(3000);
		Assert.assertTrue(Constant.driver.getPageSource().contains("退出系统"));

	}
	
	@BeforeTest
	public void beforeTest(){
		Constant.driver =OpenBrower.openBrowser("chrome");
		Constant.driver.get(Constant.url);
	}


	@AfterMethod
	public void afterMethod() throws Exception{
		Login_Action.loginOutexecute();
		Thread.sleep(1000);
	}


	@AfterSuite
	public void afterSuite(){
		Constant.driver.quit();
	}

}



