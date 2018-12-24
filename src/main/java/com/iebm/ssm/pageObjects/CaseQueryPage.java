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

    public WebElement title() throws Exception{
        element = driver.findElement(objectmap.getLocator("ssm.caseQuery.title"));
        return element;
    }

    public WebElement nav() throws Exception{
        element = driver.findElement(objectmap.getLocator("ssm.caseQuery.nav"));
        return element;
    }

    public WebElement disease() throws Exception{
        element = driver.findElement(objectmap.getLocator("ssm.caseQuery.disease"));
        return element;
    }

    public WebElement hospital() throws Exception{
        element = driver.findElement(objectmap.getLocator("ssm.caseQuery.hospital"));
        return element;
    }

    public WebElement date() throws Exception{
        element = driver.findElement(objectmap.getLocator("ssm.caseQuery.date"));
        return element;
    }

    public WebElement querybtn() throws Exception{
        element = driver.findElement(objectmap.getLocator("ssm.caseQuery.querybtn"));
        return element;
    }


    public WebElement table() throws Exception{
        element = driver.findElement(objectmap.getLocator("ssm.caseQuery.table"));
        return element;
    }

}



