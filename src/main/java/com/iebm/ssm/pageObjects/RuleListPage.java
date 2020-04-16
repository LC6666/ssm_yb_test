package com.iebm.ssm.pageObjects;

import com.iebm.ssm.util.ObjectMap;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RuleListPage {

    private WebElement element = null;
    private ObjectMap objectmap = new ObjectMap("ruleListPageMap.properties");
    private WebDriver driver;

    public RuleListPage(WebDriver driver){
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

    public WebElement name_input() throws Exception {
        element = driver.findElement(objectmap.getLocator("name_input"));
        return element;
    }

    public WebElement query_btn() throws Exception {
        element = driver.findElement(objectmap.getLocator("query_btn"));
        return element;
    }

    public WebElement reset_btn() throws Exception {
        element = driver.findElement(objectmap.getLocator("reset_btn"));
        return element;
    }

    public WebElement rulelist_table() throws Exception {
        element = driver.findElement(objectmap.getLocator("rulelist_table"));
        return element;
    }

    public WebElement pageArea_table() throws Exception {
        element = driver.findElement(objectmap.getLocator("pageArea_table"));
        return element;
    }





}
