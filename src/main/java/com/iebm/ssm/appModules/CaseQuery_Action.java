package com.iebm.ssm.appModules;

import java.util.HashMap;
import java.util.Map;

import com.iebm.ssm.util.Constant;
import org.openqa.selenium.WebDriver;

import com.iebm.ssm.pageObjects.CaseQueryPage;

/*
 *TODO
 *LC
 *下午5:02:39
 */

public class CaseQuery_Action {

    private CaseQueryPage page;

    public CaseQuery_Action() {
        // TODO Auto-generated constructor stub
        page = new CaseQueryPage(Constant.driver);
    }

    /**
     *
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





}



