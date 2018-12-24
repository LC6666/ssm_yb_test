package com.iebm.ssm.appModules;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.iebm.ssm.pageObjects.CaseQueryPage;
import com.iebm.ssm.pageObjects.IllegalPage;
import com.iebm.ssm.request.CaseQuery;
import com.iebm.ssm.request.IllegalQuery;

/*
 *TODO
 *LC
 *下午5:02:39
 */

public class CaseQuery_Action {

    private CaseQueryPage page;

    public CaseQuery_Action(WebDriver driver) {
        // TODO Auto-generated constructor stub
        page = new CaseQueryPage(driver);
    }

    /**
     * @param data.driver
     * @throws Exception
     * TODO 进入疑点查询页面
     * LC
     * 上午10:34:30
     */
    public void openPage() throws Exception {

        page.nav().click();
        Thread.sleep(300);
        page.title().click();
    }

    public void setStartDate() throws Exception{
        page.date().click();
        page.date().sendKeys("2018-12-01");

    }

    public static void query(){


    }



    public static void setParam(String url,String cookies){
        Map params = new HashMap();
        params.put("institutionName", "");
        params.put("institutionId", "");
        params.put("institutionLevelKey", "");
        params.put("diseaseName", "");
        params.put("diseaseId", "");
        params.put("startCreateTime", "2012-12-31");
        params.put("endCreateTime", "2020-03-26");
        params.put("siCode", "");
        params.put("insuredName", "");
        params.put("undefined", "");
        params.put("pageRecords", "200");
        CaseQuery.querycase(url,params, cookies);
    }

}



