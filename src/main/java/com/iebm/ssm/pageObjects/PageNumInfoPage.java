package com.iebm.ssm.pageObjects;

import com.iebm.ssm.util.ObjectMap;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @Auther: LC
 * @Date: 2019/3/7 13:32
 * @Description: 分页工具栏页面
 */

public class PageNumInfoPage {
    private WebElement element = null;
    private ObjectMap objectmap = new ObjectMap("pageNumInfoPageMap.properties");
    private WebElement root;


    public PageNumInfoPage(WebElement root) {
        // TODO Auto-generated constructor stub
        this.root = root;

    }

    public WebElement currentPageNo() throws Exception {
        element = root.findElement(objectmap.getLocator("currentPageNo"));
        return element;
    }

    public WebElement totalPageNo() throws Exception {
        element = root.findElement(objectmap.getLocator("totalPageNo"));
        return element;
    }

    public WebElement totalRecordNo() throws Exception {
        element = root.findElement(objectmap.getLocator("totalRecordNo"));
        return element;
    }

    public WebElement perPageRecord_selct() throws Exception {
        element = root.findElement(objectmap.getLocator("perPageRecord_selct"));
        return element;
    }

    public WebElement firstPage_btn() throws Exception {
        element = root.findElement(objectmap.getLocator("firstPage_btn"));
        return element;
    }

    public WebElement prePage_btn() throws Exception {
        element = root.findElement(objectmap.getLocator("prePage_btn"));
        return element;
    }

    public WebElement pageNum_input() throws Exception {
        element = root.findElement(objectmap.getLocator("pageNum_input"));
        return element;
    }

    public WebElement pageNumGo_btn() throws Exception {
        element = root.findElement(objectmap.getLocator("pageNumGo_btn"));
        return element;
    }

    public WebElement nextPage_btn() throws Exception {
        element = root.findElement(objectmap.getLocator("nextPage_btn"));
        return element;
    }

    public WebElement lastPage_btn() throws Exception {
        element = root.findElement(objectmap.getLocator("lastPage_btn"));
        return element;
    }
}
