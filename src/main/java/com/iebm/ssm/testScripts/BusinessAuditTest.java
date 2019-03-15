package com.iebm.ssm.testScripts;

import com.iebm.ssm.appModules.BusinessAudit_Action;
import com.iebm.ssm.util.TestDataDrivenByMysql;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * 稽查科调查
 * @Auther: LC
 * @Date: 2019/3/14 18:12
 * @Description:
 */

public class BusinessAuditTest {

    public BusinessAudit_Action businessAudit_action;

    @DataProvider(name = "getqueryBusinessAuditCaseData")
    public Object[][] getqueryBusinessAuditCaseData() throws ClassNotFoundException {
        return TestDataDrivenByMysql.getTestData("businessaudit_test");
    }

    @Test(testName = "openPage",priority = 0,enabled = true)
    public void openPage() throws Exception {
        businessAudit_action = new BusinessAudit_Action();
        businessAudit_action.openPage();
    }

    @Test(testName = "",priority = 1,enabled = true,dataProvider = "getqueryBusinessAuditCaseData")
    public void queryBusinessAuditCase(String index, String hospital, String hospital_level, String disease, String illegalclass, String startdate, String enddate, String sicode, String accept, String remark, String enable) throws Exception {
        businessAudit_action.queryBusinessAuditCase(index, hospital, hospital_level, disease, illegalclass, startdate, enddate, sicode, accept, remark, enable);
    }



}
