package com.iebm.ssm.pageObjects;

import com.iebm.ssm.util.ObjectMap;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UserConfigPage {

    private WebElement element = null;
    private ObjectMap objectmap = new ObjectMap("./resource/userConfigPageMap.properties");
    private WebDriver driver;

    public UserConfigPage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement nav() throws Exception {
        element = driver.findElement(objectmap.getLocator("nav"));
        return element;
    }

    public WebElement title() throws Exception {
        element = driver.findElement(objectmap.getLocator("title"));
        return element;
    }

    public WebElement orgTreeTable() throws Exception {
        element = driver.findElement(objectmap.getLocator("orgTreeTable"));
        return element;
    }

    public WebElement addUserBtn() throws Exception{
        element = driver.findElement(objectmap.getLocator("addUserBtn"));
        return element;
    }


}
