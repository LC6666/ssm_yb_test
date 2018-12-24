package com.iebm.ssm.testScripts;


import org.testng.annotations.Test;
import com.iebm.ssm.appModules.CaseQuery_Action;
import com.iebm.ssm.util.Constant;

public class CaseQueryTest {
	String baseUrl = Constant.url;
	
	
	@Test(testName="进入病例查询页面",priority=1,dependsOnGroups = "login")
	public void testIllegal() throws Exception{
		CaseQuery_Action casequery = new CaseQuery_Action(Constant.driver);
		casequery.openPage();
		Thread.sleep(500);
		
	}
	
	@Test(testName="疑点查询接口",priority=2,enabled = false)
	public void illgealQuery(){
		CaseQuery_Action casequery = new CaseQuery_Action(Constant.driver);
		casequery.setParam(baseUrl,Constant.driver.manage().getCookies().toString());
	}
	

	
}
