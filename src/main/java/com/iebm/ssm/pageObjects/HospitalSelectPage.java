package com.iebm.ssm.pageObjects;

import com.iebm.ssm.util.Constant;
import com.iebm.ssm.util.ObjectMap;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HospitalSelectPage {

    private WebElement element = null;
    private ObjectMap objectmap = new ObjectMap("./resource/hospitalSelectPageMap.properties");
    private WebDriver driver;

    public HospitalSelectPage() {
        // TODO Auto-generated constructor stub
        this.driver = Constant.driver;
    }


    public WebElement hospitalname_input() throws Exception {
        element = driver.findElement(objectmap.getLocator("hospitalname_input"));
        return element;
    }

    public WebElement hospitalquery_btn() throws Exception {
        element = driver.findElement(objectmap.getLocator("hospitalquery_btn"));
        return element;
    }

    public WebElement hospitalclear_btn() throws Exception {
        element = driver.findElement(objectmap.getLocator("hospitalclear_btn"));
        return element;
    }

    public WebElement hospitallist() throws Exception {
        element = driver.findElement(objectmap.getLocator("hospitallist"));
        return element;
    }

    public WebElement changePageRecords() throws Exception {
        element = driver.findElement(objectmap.getLocator("changePageRecords"));
        return element;
    }

    public WebElement firstPage_btn() throws Exception {
        element = driver.findElement(objectmap.getLocator("firstPage_btn"));
        return element;
    }

    public WebElement prePage_btn() throws Exception {
        element = driver.findElement(objectmap.getLocator("prePage_btn"));
        return element;
    }

    public WebElement pageNum_input() throws Exception {
        element = driver.findElement(objectmap.getLocator("pageNum_input"));
        return element;
    }

    public WebElement pageNumGo_btn() throws Exception {
        element = driver.findElement(objectmap.getLocator("pageNumGo_btn"));
        return element;
    }

    public WebElement netPage_btn() throws Exception {
        element = driver.findElement(objectmap.getLocator("netPage_btn"));
        return element;
    }

    public WebElement lastPage_btn() throws Exception {
        element = driver.findElement(objectmap.getLocator("lastPage_btn"));
        return element;
    }

    public WebElement hospitalconfirm_btn() throws Exception {
        element = driver.findElement(objectmap.getLocator("hospitalconfirm_btn"));
        return element;
    }

    public WebElement hospitalselectclear_btn() throws Exception {
        element = driver.findElement(objectmap.getLocator("hospitalselectclear_btn"));
        return element;
    }

    public WebElement hospitalcancel_btn() throws Exception {
        element = driver.findElement(objectmap.getLocator("hospitalcancel_btn"));
        return element;
    }



}
