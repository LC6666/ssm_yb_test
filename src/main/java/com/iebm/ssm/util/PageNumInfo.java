package com.iebm.ssm.util;

import com.iebm.ssm.pageObjects.PageNumInfoPage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: LC
 * @Date: 2019/3/7 14:05
 * @Description:
 */

public class PageNumInfo {

    public WebElement pageSet;
    private PageNumInfoPage page;

    public PageNumInfo(WebElement pageinfo){
        setPageSet(pageinfo);
        page = new PageNumInfoPage(pageSet);
    }

    public void setPageSet(WebElement pageinfo) {
        // TODO Auto-generated method stub
        this.pageSet = pageinfo;
    }

    public WebElement getPageSet(){
        return pageSet;
    }

    public Map getPageInfo() throws Exception {

        PageNumInfoPage page = new PageNumInfoPage(pageSet);
        String pageNo = page.currentPageNo().getText();
        String totalPageNo = page.totalPageNo().getText();
        String totalRecordNum = page.totalRecordNo().getText();
        Map pageinfo = new HashMap();
        pageinfo.put("pageNo", pageNo);
        pageinfo.put("totalPageNo", totalPageNo);
        pageinfo.put("totalRecordNum", totalRecordNum);
        return pageinfo;
    }


    public String getCurrentPageNo() throws Exception {
        return page.currentPageNo().getText();
    }

    public String getTotalPageNo() throws Exception {
        return page.totalPageNo().getText();
    }

    public String totalRecordNo() throws Exception {
        return page.totalRecordNo().getText();
    }

    public void setPerPageNo(String text) throws Exception {
        Select select = new Select(page.perPageRecord_selct());
        select.selectByVisibleText(text);
    }

    public void goPageNo(String pageNo) throws Exception {
        page.pageNum_input().clear();
        page.pageNum_input().sendKeys(pageNo);
        page.pageNumGo_btn().click();
    }

    public void btnClick(String btn_name) throws Exception {
        if(btn_name.equals("first")){
            page.firstPage_btn().click();
        }else if (btn_name.equals("next")){
            page.nextPage_btn().click();
        }else if (btn_name.equals("pre")){
            page.prePage_btn().click();
        }else if (btn_name.equals("last")){
            page.lastPage_btn().click();
        }
    }


}
