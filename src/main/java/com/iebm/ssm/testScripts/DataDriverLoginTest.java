package com.iebm.ssm.testScripts;


import com.iebm.ssm.appModules.Login_Action;
import com.iebm.ssm.util.TestDataDrivenByCSVFile;
import com.iebm.ssm.util.Constant;
import com.iebm.ssm.util.Log;
import com.iebm.ssm.util.OpenBrower;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;

/*
 *TODO
 *LC
 *下午6:19:28
*/

@Test(groups = "login")
public class DataDriverLoginTest {

	String baseUrl = Constant.url;

	@DataProvider(name="loginInfo")
	public static Object[][] loginInfo(){
		return  new Object[][]{{"ssm","83881021"},{"1001","666666"}};
	}

	@DataProvider(name="loginData")
	public static Object[][] loginData() throws IOException {
		return TestDataDrivenByCSVFile.getTestData("./resource/login_data.csv");
	}


	@Test(testName = "用户登录",dataProvider = "loginInfo",priority = 1)
	public void dataDriverLogin(String loginid,String password) throws Exception{
		Log.info("使用DataDriver测试");
		Login_Action.execute(loginid, password);
		Thread.sleep(3000);
		Assert.assertTrue(Constant.driver.getPageSource().contains("退出系统"));
	}

	@Test(testName = "用户登录",dataProvider = "loginData",priority = 2)
	public void dataDriverLoginFromCSV(String loginid,String password) throws Exception{
		Log.info("使用DataDriver测试");
		Login_Action.execute(loginid, password);
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
//		Constant.driver.quit();
	}

}



