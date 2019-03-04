package com.iebm.ssm.testScripts;


import com.iebm.ssm.appModules.Login_Action;
import com.iebm.ssm.util.Constant;
import com.iebm.ssm.util.Log;
import com.iebm.ssm.util.OpenBrower;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/*
 *TODO
 *LC
 *下午6:19:28
*/

@Test(groups = "login")
public class LoginTest {

	String baseUrl = Constant.url;
	
	@Test(testName = "用户登录")
	public void testLogin() throws Exception{
		Log.info("调用Login_Action.execute");
		Login_Action.execute(Constant.driver, Constant.loginUsername, Constant.loginPassword);
		Thread.sleep(3000);
		Assert.assertTrue(Constant.driver.getPageSource().contains("退出系统"));

	}

	@Test(testName = "管理员登录")
	public void admintLogin() throws Exception{
		Log.info("调用Login_Action.execute");
		Login_Action.execute(Constant.driver, "1001", "666666");
		Thread.sleep(3000);
		Assert.assertTrue(Constant.driver.getPageSource().contains("退出系统"));

	}
	
	@BeforeTest
	public void beforeMethod(){
		Constant.driver =OpenBrower.openBrowser("chrome");
		Constant.driver.get(Constant.url);
	}
	
	@AfterSuite
	public void afterMethod(){
//		Constant.driver.quit();
	}

}



