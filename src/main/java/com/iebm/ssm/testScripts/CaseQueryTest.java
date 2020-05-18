package com.iebm.ssm.testScripts;


import com.iebm.ssm.util.TestDataDrivenByCSVFile;
import com.iebm.ssm.util.TestDataDrivenByExcelFile;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.iebm.ssm.appModules.CaseQuery_Action;
import com.iebm.ssm.util.Constant;

import java.io.IOException;

public class CaseQueryTest {

	private CaseQuery_Action casequery;

	@DataProvider(name = "hospitalnamedata")
	public Object[][] testdata() throws IOException {
//		return TestDataDrivenByExcelFile.getDataFromXlxs("./resource/", "hos_name.xlsx", "Sheet1");
		return TestDataDrivenByCSVFile.getTestData("hospitalname.csv");
	}

	
	@Test(testName="进入病例查询页面",priority=1)
	public void testIllegal() throws Exception{
		casequery = new CaseQuery_Action();
		casequery.openPage();
		Thread.sleep(500);
		
	}

	@Test(testName="查询病例",priority=2,enabled = false)
	public void queryCase() throws Exception{
		casequery.query(null,null,null,null,null,null,null);
	}

	/**
	 * 医疗机构查询
	 * @param index
	 * @param hospitalname
	 * @throws Exception
	 */
	@Test(testName = "hospitalquery",dataProvider = "hospitalnamedata",priority = 2)
	public void queryHospital(String index,String hospitalname) throws Exception{
		casequery.queryHospital(hospitalname);
	}

	

	
}
