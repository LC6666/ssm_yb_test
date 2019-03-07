package com.iebm.ssm.testScripts;


import org.testng.annotations.Test;
import com.iebm.ssm.appModules.CaseQuery_Action;
import com.iebm.ssm.util.Constant;

public class CaseQueryTest {

	private CaseQuery_Action casequery;


	
	@Test(testName="进入病例查询页面",priority=1)
	public void testIllegal() throws Exception{
		casequery = new CaseQuery_Action();
		casequery.openPage();
		Thread.sleep(500);
		
	}

	@Test(testName="查询病例",priority=2)
	public void queryCase() throws Exception{
		casequery.query(null,null,null,null,null,null,null);
	}

	

	
}
