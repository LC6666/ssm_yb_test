package com.iebm.ssm.appModules;

import com.iebm.ssm.util.Constant;
import com.iebm.ssm.util.UpdateAttribute;
import org.openqa.selenium.WebDriver;

import com.iebm.ssm.pageObjects.DynamicWarnPage;

/*
 *TODO
 *LC
 *下午5:59:15
 */

public class DynamicWarn_Action {

    private DynamicWarnPage dwp;

    public DynamicWarn_Action() {
        // TODO Auto-generated constructor stub
        dwp = new DynamicWarnPage();
    }


    /**
     *
     * @throws Exception
     * TODO 进入动态预警页面
     * LC
     * 上午10:34:30
     */
    public void openPage() throws Exception {

        dwp.nav().click();
        Thread.sleep(500);
        dwp.title().click();
		Thread.sleep(500);
		dwp.querybtn().click();
    }

    public void setStartDate() throws Exception{
        UpdateAttribute.removeAttribute(Constant.driver, dwp.date(), "readonly");
        dwp.date().clear();
        dwp.date().sendKeys("2017-12-01");

    }


    public void query() throws Exception {
        dwp.querybtn().click();
    }
}



