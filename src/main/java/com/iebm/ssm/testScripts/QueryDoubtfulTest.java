package com.iebm.ssm.testScripts;

import com.iebm.ssm.util.TestDataDrivenByMysql;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.iebm.ssm.appModules.QueryDoubtful_Action;

public class QueryDoubtfulTest {

	private QueryDoubtful_Action queryDoubtful_action;


	@DataProvider(name = "getqeuryDoubtfulCaseData")
	public Object[][] getqeuryDoubtfulCaseData() throws ClassNotFoundException {
		return TestDataDrivenByMysql.getTestData("querydoubtful_test");
	}

	
	@Test(testName="openPage",priority=1)
	public void openPage() throws Exception{
		queryDoubtful_action = new QueryDoubtful_Action() ;
		queryDoubtful_action.openPage();
		
	}

	@Test(testName="查询病例",priority=2,enabled = true,dataProvider = "getqeuryDoubtfulCaseData")
	public void qeuryDoubtfulCase(String index,String hospital,String hospital_level,String disease,String handleState,String startdate,String enddate,String ruleNum,String sicode,String illegalclass,String insuredname,String enable) throws Exception {
		/*illegal.setCondition("铜川市人民医院",
				"三级", "肺炎", "智审完成",
				"2013-08-10", "2018-08-10", "3条以上",
				"000000010016510", "违规", "王");*/
		queryDoubtful_action.setCondition(hospital,
				hospital_level, disease, handleState,
				startdate, enddate, ruleNum,
				sicode, illegalclass, insuredname,enable);
	}

	
}
