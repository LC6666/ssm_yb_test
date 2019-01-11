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

	private Illegal_Action illegal;


	
	@Test(testName="进入疑点查询",priority=1)
	public void querytIllegal() throws Exception{
		illegal = new Illegal_Action() ;
		illegal.openPage();
		
	}

	@Test(testName="查询病例",priority=2)
	public void test() throws Exception {
		illegal.setCondition("铜川市人民医院",
				"三级", "肺炎", "智审完成",
				"2013-08-10", "2018-08-10", "3条以上",
				"000000010016510", "违规", "王");
	}

	
}
