package com.iebm.ssm.appModules;import org.openqa.selenium.WebDriver;import com.iebm.ssm.pageObjects.TotalReportPage;/* *TODO *LC *下午12:20:22 */public class TotalReport_Action {    public static void openPage(WebDriver driver) throws Exception{        TotalReportPage page = new TotalReportPage(driver);        page.nav().click();        Thread.sleep(300);        page.title().click();    }}