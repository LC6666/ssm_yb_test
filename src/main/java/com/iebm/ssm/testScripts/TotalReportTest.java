package com.iebm.ssm.testScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.iebm.ssm.appModules.Login_Action;
import com.iebm.ssm.appModules.TotalReport_Action;
import com.iebm.ssm.request.API_queryReportDoubtCountListForJZ;
import com.iebm.ssm.util.Constant;
import com.iebm.ssm.util.Log;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/*
 *TODO
 *LC
 *下午12:22:50
*/

public class TotalReportTest {

	String baseUrl = Constant.url;
	
	@Test(testName="进入总体统计",priority=1)
	public void testOpenPage() throws Exception{
		TotalReport_Action.openPage(Constant.driver);
		/*Set<Cookie> cookies =  driver.manage().getCookies();
		for (Cookie cookie : cookies) {
			System.out.println(String.format("%s->%s->%s->%s->%s", cookie.getDomain(),cookie.getName(),cookie.getValue(),cookie.getExpiry(),cookie.getPath()));
		}*/
		
		API_queryReportDoubtCountListForJZ.test(baseUrl,Constant.driver.manage().getCookies().toString());
		
		
	}
	

}



