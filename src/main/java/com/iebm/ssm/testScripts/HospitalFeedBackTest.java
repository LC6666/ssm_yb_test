package com.iebm.ssm.testScripts;

import com.iebm.ssm.appModules.HospitalFeedBack_Action;
import com.iebm.ssm.util.TestDataDrivenByExcelFile;
import com.iebm.ssm.util.TestDataDrivenByMysql;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import javax.xml.ws.RequestWrapper;
import java.io.IOException;

/**
 * @Auther: LC
 * @Date: 2019/3/12 13:26
 * @Description:
 */

public class HospitalFeedBackTest {

    private HospitalFeedBack_Action hospitalFeedBack;

    @DataProvider(name = "getTestCaseDate")
    public Object[][] getTestCaseDate() throws ClassNotFoundException {
//        return TestDataDrivenByExcelFile.getDataFromXlxs("./resource","AuditCase.xlsx","医院违规病例反馈");
        return TestDataDrivenByMysql.getTestData("hospitalfeedback_test");
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
     * 选择病例反馈
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
    @Test(testName = "queryCaseFeedBack",priority = 1,enabled = true,dataProvider = "getTestCaseDate")
    public void queryCaseFeedBack(String index,String diseasename,String startdate,String enddate,String sicode,String accpet,String remark,String filepath,String enable) throws Exception {
        hospitalFeedBack.queryCaseFeedBack(index,diseasename,startdate,enddate,sicode,accpet,remark,filepath,enable);
    }




}
