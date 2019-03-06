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



	@Test(testName = "dataDriverLogin1",dataProvider = "loginInfo")
	public void dataDriverLogin(String loginid,String password) throws Exception{
		Log.info("使用DataDriver测试");
		Login_Action.execute(loginid, password);
		Thread.sleep(3000);
		Assert.assertTrue(Constant.driver.getPageSource().contains("退出系统"));
	}


	@Test(testName = "dataDriverLoginFromCSV",dataProvider = "loginData")
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
		Constant.driver.quit();
	}

}



