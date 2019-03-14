package com.iebm.ssm.testScripts;

import com.iebm.ssm.appModules.HospitalDoubtFeedBack_Action;
import com.iebm.ssm.util.TestDataDrivenByMysql;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * 医院疑似违规病例反馈
 * @Auther: LC
 * @Date: 2019/3/14 10:04
 * @Description:
 */

public class HospitalDoubtFeedBackTest {

    public HospitalDoubtFeedBack_Action hospitalDoubtFeedBack_action;

    @DataProvider(name = "queryFeedBackCaseData")
    public Object[][] queryFeedBackCaseData() throws ClassNotFoundException {
        return TestDataDrivenByMysql.getTestData("hospitaldoubtfeedback_test");
    }

    /**
     * 打开页面
     * @throws Exception
     */
    @Test(testName="openPage",priority = 0,enabled = true)
    public void openPage() throws Exception {
        hospitalDoubtFeedBack_action = new HospitalDoubtFeedBack_Action();
        hospitalDoubtFeedBack_action.openPage();
    }

    /**
     * 查询病例
     * @param index
     * @param disease
     * @param startdate
     * @param enddate
     * @param sicode
     * @param accpet
     * @param remark
     * @param filepath
     * @param enable
     * @throws Exception
     */
    @Test(testName="queryFeedBackCase",priority = 1,enabled = true,dataProvider = "queryFeedBackCaseData")
    public void queryFeedBackCase(String index,String disease,String startdate,String enddate,String sicode,String accpet,String remark,String filepath,String enable) throws Exception {
        hospitalDoubtFeedBack_action.queryFeedBackCase(index,disease,startdate,enddate,sicode,accpet,filepath,enable);

    }
}
