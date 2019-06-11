package com.iebm.ssm.testScripts;

import com.iebm.ssm.appModules.ReviewSencond_Action;
import com.iebm.ssm.util.TestDataDrivenByExcelFile;
import com.iebm.ssm.util.TestDataDrivenByMysql;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * 人工复审
 * @Auther: LC
 * @Date: 2019/3/14 12:40
 * @Description:
 */

public class ReviewSencondTest {

    public ReviewSencond_Action reviewSencond_action;

    @DataProvider(name = "getReviewCaseDataFromMysql")
    public Object[][] getReviewCaseDataFromMysql() throws ClassNotFoundException {
        return TestDataDrivenByMysql.getTestData("reviewsecond_test");
    }

    @DataProvider(name="getReviewCaseDataFromExcel")
    public Object[][] getReviewCaseDataFromExcel() throws ClassNotFoundException, IOException {
        return TestDataDrivenByExcelFile.getDataFromXlxs("./resource","test_data.xlsx","人工复审" );
    }

    /**
     * 打开人工复审
     * @throws Exception
     */
    @Test(testName = "openPage",priority = 0,enabled = true)
    public void openPage() throws Exception {
        reviewSencond_action = new ReviewSencond_Action();
        reviewSencond_action.openPage();
    }

    @Test(testName = "queryReviewCase",priority = 1,enabled = true,dataProvider = "getReviewCaseDataFromMysql")
    public void queryReviewCase(String index, String hospital, String hospital_level, String disease, String startdate, String enddate, String illegalClass, String siCode, String nextState, String remark, String enable) throws Exception {
        reviewSencond_action.queryReviewCase(index, hospital, hospital_level, disease, startdate, enddate, illegalClass, siCode, nextState, remark, enable);
    }

}
