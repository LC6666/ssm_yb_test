package com.iebm.ssm.testScripts;

import com.iebm.ssm.appModules.ReviewFirst_Action;
import org.testng.annotations.Test;

/**
 * 人工初审
 * @Auther: LC
 * @Date: 2019/3/13 17:20
 * @Description:
 */

public class ReviewFirstTest {
    public ReviewFirst_Action reviewFirst_action;

    /**
     * 进入疑点审核，打开人工初审
     * @throws Exception
     */
    @Test(testName = "openPage",priority = 0,enabled = true)
    public void openPage() throws Exception {
        reviewFirst_action = new ReviewFirst_Action();
        reviewFirst_action.openPage();
    }

    @Test(testName = "queryReviewCase",priority = 1,enabled = true)
    public void queryReviewCase(String index,String hospital,String hospital_level,String disease,String startdate,String endate,String illegalClass,String siCode,String nextstate,String remark,String enable) throws Exception {
        reviewFirst_action.queryReviewCase(index,hospital,hospital_level,disease,startdate,endate,illegalClass,siCode,nextstate,remark,enable);
    }
}
