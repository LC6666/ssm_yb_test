package com.iebm.ssm.pageObjects;

import com.iebm.ssm.util.Constant;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.iebm.ssm.util.ObjectMap;

/*
 *TODO
 *LC
 *下午5:56:19
 */

public class DynamicWarnPage {
    private WebElement element = null;
    private ObjectMap  objectmap = new ObjectMap("./resource/dynamicWarnPageMap.properties");
    private WebDriver driver;

    public DynamicWarnPage() {
        // TODO Auto-generated constructor stub
        this.driver = Constant.driver;
    }

    public WebElement title() throws Exception{
        element = driver.findElement(objectmap.getLocator("ssm.dynamicWarn.title"));
        return element;
    }

    public WebElement nav() throws Exception{
        element = driver.findElement(objectmap.getLocator("ssm.dynamicWarn.nav"));
        return element;
    }

    public WebElement disease() throws Exception{
        element = driver.findElement(objectmap.getLocator("ssm.dynamicWarn.disease"));
        return element;
    }

    public WebElement hospital() throws Exception{
        element = driver.findElement(objectmap.getLocator("ssm.dynamicWarn.hospital"));
        return element;
    }

    public WebElement date() throws Exception{
        element = driver.findElement(objectmap.getLocator("ssm.dynamicWarn.date"));
        return element;
    }

    public WebElement querybtn() throws Exception{
        element = driver.findElement(objectmap.getLocator("ssm.dynamicWarn.querybtn"));
        return element;
    }


    public WebElement table() throws Exception{
        element = driver.findElement(objectmap.getLocator("ssm.dynamicWarn.table"));
        return element;
    }
}



