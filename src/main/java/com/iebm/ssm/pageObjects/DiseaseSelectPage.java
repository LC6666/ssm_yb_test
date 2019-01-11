package com.iebm.ssm.pageObjects;

import com.iebm.ssm.util.Constant;
import com.iebm.ssm.util.ObjectMap;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * 医疗机构选择弹窗
 */
public class DiseaseSelectPage {

    private WebElement element = null;
    private ObjectMap objectmap = new ObjectMap("./resource/diseaseSelectPageMap.properties");
    private WebDriver driver;

    public DiseaseSelectPage() {
        // TODO Auto-generated constructor stub
        this.driver = Constant.driver;
    }


    public WebElement diseasename_input() throws Exception {
        element = driver.findElement(objectmap.getLocator("diseasename_input"));
        return element;
    }

    public WebElement diseasequery_btn() throws Exception {
        element = driver.findElement(objectmap.getLocator("diseasequery_btn"));
        return element;
    }

    public WebElement diseaseclear_btn() throws Exception {
        element = driver.findElement(objectmap.getLocator("diseaseclear_btn"));
        return element;
    }

    public WebElement diseaselist() throws Exception {
        element = driver.findElement(objectmap.getLocator("diseaselist"));
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

    public WebElement diseaseconfirm_btn() throws Exception {
        element = driver.findElement(objectmap.getLocator("diseaseconfirm_btn"));
        return element;
    }

    public WebElement diseaseselectclear_btn() throws Exception {
        element = driver.findElement(objectmap.getLocator("diseaseselectclear_btn"));
        return element;
    }

    public WebElement diseasecancel_btn() throws Exception {
        element = driver.findElement(objectmap.getLocator("diseasecancel_btn"));
        return element;
    }



}
