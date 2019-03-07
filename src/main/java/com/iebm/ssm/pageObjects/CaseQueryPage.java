package com.iebm.ssm.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.iebm.ssm.util.ObjectMap;

/*
 *TODO
 *LC
 *下午5:01:10
 */

public class CaseQueryPage {
    private WebElement element = null;
    private ObjectMap  objectmap = new ObjectMap("./resource/caseQueryPageMap.properties");
    private WebDriver driver;

    public CaseQueryPage(WebDriver driver) {
        // TODO Auto-generated constructor stub
        this.driver = driver;
    }

    public WebElement nav() throws Exception{
        element = driver.findElement(objectmap.getLocator("nav"));
        return element;
    }

    public WebElement title() throws Exception{
        element = driver.findElement(objectmap.getLocator("title"));
        return element;
    }


    public WebElement hospital_input() throws Exception{
        element = driver.findElement(objectmap.getLocator("hospital_input"));
        return element;
    }
    public WebElement hospital_img() throws Exception{
        element = driver.findElement(objectmap.getLocator("hospital_img"));
        return element;
    }
    public WebElement hospital_level_select() throws Exception{
        element = driver.findElement(objectmap.getLocator("hospital_level_select"));
        return element;
    }
    public WebElement disease_input() throws Exception{
        element = driver.findElement(objectmap.getLocator("disease_input"));
        return element;
    }
    public WebElement disease_img() throws Exception{
        element = driver.findElement(objectmap.getLocator("disease_img"));
        return element;
    }
    public WebElement startdate_input() throws Exception{
        element = driver.findElement(objectmap.getLocator("startdate_input"));
        return element;
    }
    public WebElement enddate_input() throws Exception{
        element = driver.findElement(objectmap.getLocator("enddate_input"));
        return element;
    }
    public WebElement siCode_input() throws Exception{
        element = driver.findElement(objectmap.getLocator("siCode_input"));
        return element;
    }
    public WebElement insuredName_input() throws Exception{
        element = driver.findElement(objectmap.getLocator("insuredName_input"));
        return element;
    }
    public WebElement query_btn() throws Exception{
        element = driver.findElement(objectmap.getLocator("query_btn"));
        return element;
    }
    public WebElement reset_btn() throws Exception{
        element = driver.findElement(objectmap.getLocator("reset_btn"));
        return element;
    }
    public WebElement resultlist_table() throws Exception{
        element = driver.findElement(objectmap.getLocator("resultlist_table"));
        return element;
    }
    public WebElement pageArea_table() throws Exception{
        element = driver.findElement(objectmap.getLocator("pageArea_table"));
        return element;
    }
}



