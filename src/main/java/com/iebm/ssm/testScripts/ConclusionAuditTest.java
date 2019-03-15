package com.iebm.ssm.testScripts;

import com.iebm.ssm.appModules.ConclusionAudit_Action;
import com.iebm.ssm.util.TestDataDrivenByMysql;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * 疑点结论
 * @Auther: LC
 * @Date: 2019/3/14 18:27
 * @Description:
 */

public class ConclusionAuditTest {

    public ConclusionAudit_Action conclusionAudit_action;

    @DataProvider(name = "getqueryConclusionCaseData")
    public Object[][] getqueryConclusionCaseData() throws ClassNotFoundException {
        return TestDataDrivenByMysql.getTestData("conclusionaudit_test");
    }

    @Test(testName = "openPage",priority = 0,enabled = true)
    public void openPage() throws Exception {
        conclusionAudit_action = new ConclusionAudit_Action();
        conclusionAudit_action.openPage();
    }

    @Test(testName = "queryConclusionCase",priority = 0,enabled = true,dataProvider = "getqueryConclusionCaseData")
    public void queryConclusionCase(String index, String hospital, String hospital_level, String disease, String illegalclass, String startdate, String enddate, String illegalresult,String sicode, String enable ) throws Exception {
        conclusionAudit_action.queryConclusionCase(index, hospital, hospital_level, disease, illegalclass, startdate, enddate, illegalresult,sicode, enable);
    }


}
