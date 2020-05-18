package com.iebm.ssm.testScripts;

import com.iebm.ssm.appModules.ExpertReview_Action;
import com.iebm.ssm.util.TestDataDrivenByExcelFile;
import com.iebm.ssm.util.TestDataDrivenByMysql;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * 专家审核
 * @Auther: LC
 * @Date: 2019/3/14 17:47
 * @Description:
 */

public class ExpertReviewTest {
    public ExpertReview_Action expertReview_action;

    @DataProvider(name = "getExpertReviewCaseDataFromMysql")
    public Object[][] getExpertReviewCaseDataFromMysql() throws ClassNotFoundException {
        return TestDataDrivenByMysql.getTestData("expertreview_test");
    }

    @DataProvider(name="getExpertReviewCaseDataFromExcel")
    public Object[][] getExpertReviewCaseDataFromExcel() throws ClassNotFoundException, IOException {
        return TestDataDrivenByExcelFile.getDataFromXlxs("test_data.xlsx","专家审核" );
    }

    @Test(testName = "openPage",priority = 0,enabled = true)
    public void openPage() throws Exception {
        expertReview_action = new ExpertReview_Action();
        expertReview_action.openPage();
    }

    @Test(testName = "queryReviewCase",priority = 1,enabled = true,dataProvider = "getExpertReviewCaseDataFromMysql")
    public void queryReviewCase(String index,String hospital,String hospital_level,String disease,String illegalclass,String startdate,String enddate,String sicode,String accept,String remark,String enable) throws Exception {
        expertReview_action.queryReviewCase(index,hospital,hospital_level,disease,illegalclass,startdate,enddate,sicode,accept,remark,enable);
    }
}
