package com.iebm.ssm.testScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.iebm.ssm.appModules.Illegal_Action;
import com.iebm.ssm.appModules.Login_Action;
import com.iebm.ssm.util.Constant;
import com.iebm.ssm.util.Log;
import com.iebm.ssm.util.UpdateAttribute;

public class IllegalPageTest {
	

	String baseUrl = Constant.url;
	Illegal_Action illegal ;
	
	@Test(testName="进入疑点查询页面查询数据",priority=1)
	public void querytIllegal() throws Exception{
		illegal = new Illegal_Action();
		illegal.openPage();
		illegal.setStartDate(Constant.driver, "2017-05-01");
		illegal.setEndDate(Constant.driver, "2019-06-01");
		Thread.sleep(500);
		illegal.query();
		
	}
	
	@Test(testName="查看列表数据",priority=2,enabled=false)
	public void getTable() throws Exception{
		Thread.sleep(1000);
		Illegal_Action illegal = new Illegal_Action();
		illegal.readTable();
	}
	
	@Test(testName="核验病例数据",priority=3)
	public void getRowData() throws Exception{
		Thread.sleep(1000);
		illegal = new Illegal_Action();
		illegal.readTableRow();
	}

	

	
}
