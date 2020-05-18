package com.iebm.ssm.testScripts;

import com.iebm.ssm.appModules.HospitalFeedBack_Action;
import com.iebm.ssm.util.TestDataDrivenByExcelFile;
import com.iebm.ssm.util.TestDataDrivenByMysql;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.IOException;

/**
 * 医院违规病例反馈
 * @Auther: LC
 * @Date: 2019/3/12 13:26
 * @Description:
 */

public class HospitalFeedBackTest {

    private HospitalFeedBack_Action hospitalFeedBack;

    @DataProvider(name = "getTestCaseDateFromMysql")
    public Object[][] getTestCaseDate() throws ClassNotFoundException {
        return TestDataDrivenByMysql.getTestData("hospitalfeedback_test");
    }

    @DataProvider(name="getTestCaseDateFromExcel")
    public static Object[][] getloginDataByExcel2() throws IOException {
        return TestDataDrivenByExcelFile.getDataFromXlxs("test_data.xlsx","医院违规病例反馈");
    }

    /**
     * 进入疑点审核，打开医院违规病例反馈
     * @throws Exception
     */
    @Test(testName = "HospitalFeedBackTest",priority = 0,enabled = true)
    public void openPage() throws Exception {
        hospitalFeedBack = new HospitalFeedBack_Action();
        hospitalFeedBack.openPage();
    }



    /**
     * 查询病例反馈
     * @param index
     * @param diseasename
     * @param startdate
     * @param enddate
     * @param sicode
     * @param accpet
     * @param remark
     * @param filepath
     * @throws Exception
     */
    @Test(testName = "queryCaseFeedBack",priority = 1,enabled = false,dataProvider = "getTestCaseDateFromMysql")
    public void queryCaseFeedBack(String index,String diseasename,String startdate,String enddate,String sicode,String accpet,String remark,String filepath,String enable) throws Exception {
        hospitalFeedBack.queryCaseFeedBack(index,diseasename,startdate,enddate,sicode,accpet,remark,filepath,enable);
    }


    /**
     * 查询病例反馈
     * @param index
     * @param diseasename
     * @param startdate
     * @param enddate
     * @param sicode
     * @param accpet
     * @param remark
     * @param filepath
     * @param enable
     */
    @Test(testName = "queryCaseFeedBack2",priority = 2,enabled = true,dataProvider = "getTestCaseDateFromMysql")
    public void queryCaseFeedBack2(String index,String diseasename,String startdate,String enddate,String sicode,String accpet,String remark,String filepath,String enable) throws Exception {
        hospitalFeedBack.queryCaseFeedBack2(index,diseasename,startdate,enddate,sicode,accpet,remark,filepath,enable );
    }




}
