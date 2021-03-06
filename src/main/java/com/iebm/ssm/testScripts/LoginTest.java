package com.iebm.ssm.testScripts;


import com.iebm.ssm.appModules.Login_Action;
import com.iebm.ssm.util.Constant;
import com.iebm.ssm.util.Log;
import com.iebm.ssm.util.OpenBrower;
import org.testng.Assert;
import org.testng.annotations.*;

/*
 *TODO 登录
 *LC
 *下午6:19:28
*/

public class LoginTest {


	@Test(testName = "guestLogin")
	public void guestLogin() throws Exception{
		Log.info("调用Login_Action.execute");
		Login_Action.execute(Constant.loginUsername, Constant.loginPassword);
		Thread.sleep(3000);
		Assert.assertTrue(Constant.driver.getPageSource().contains("退出系统"));

	}

	@Test(testName = "ssmLogin")
	public void ssmLogin() throws Exception{
		Log.info("调用Login_Action.execute");
		Login_Action.execute("ssm", "888888");
		Thread.sleep(3000);
		Assert.assertTrue(Constant.driver.getPageSource().contains("退出系统"));

	}

	@Test(testName = "adminLogin")
	public void admintLogin() throws Exception{
		Log.info("调用Login_Action.execute");
		Login_Action.execute("1001", "666666");
		Thread.sleep(3000);
		Assert.assertTrue(Constant.driver.getPageSource().contains("退出系统"));

	}


	
	@BeforeTest
	public void beforeTest(){
		Constant.driver =OpenBrower.openBrowser("chrome");
		Constant.driver.get(Constant.url);
	}

	@AfterSuite
	public void afterSuite(){

//		Constant.driver.quit();
	}

}



