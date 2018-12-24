package com.iebm.ssm.testScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.iebm.ssm.appModules.DynamicWarn_Action;
import com.iebm.ssm.appModules.Login_Action;
import com.iebm.ssm.util.Constant;
import com.iebm.ssm.util.Log;

/*
 *TODO
 *LC
 *下午6:06:12
*/

public class DynamicWarnTest {
	
//	public WebDriver driver = Constant.driver;
	String baseUrl = Constant.url;

	
	@Test(testName="进入动态预警",dependsOnGroups = "login",priority=1)
	public void testDynamicWarn() throws Exception{
		DynamicWarn_Action dwa = new DynamicWarn_Action();
		dwa.openPage();
		Thread.sleep(500);
		dwa.setStartDate();
		dwa.query();
		
	}
	
	


}



