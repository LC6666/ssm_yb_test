package com.iebm.ssm.pageObjects;

import com.iebm.ssm.util.ObjectMap;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @Auther: LC
 * @Date: 2019/3/12 17:43
 * @Description:
 */

public class ReviewFirstPage {
    private WebElement element = null;
    private ObjectMap objectmap = new ObjectMap("./resource/reviewFirstPageMap.properties");
    private WebDriver driver;

    public ReviewFirstPage(WebDriver driver) {
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
    public WebElement illegalClass_select() throws Exception{
        element = driver.findElement(objectmap.getLocator("illegalClass_select"));
        return element;
    }
    public WebElement siCode_input() throws Exception{
        element = driver.findElement(objectmap.getLocator("siCode_input"));
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
    public WebElement firstTrial_btn() throws Exception{
        element = driver.findElement(objectmap.getLocator("firstTrial_btn"));
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

    public WebElement nextstate_select() throws Exception{
        element = driver.findElement(objectmap.getLocator("nextstate_select"));
        return element;
    }

    public WebElement remark_text() throws Exception{
        element = driver.findElement(objectmap.getLocator("remark_text"));
        return element;
    }

    public WebElement commit_btn() throws Exception{
        element = driver.findElement(objectmap.getLocator("commit_btn"));
        return element;
    }
    public WebElement close_btn() throws Exception{
        element = driver.findElement(objectmap.getLocator("close_btn"));
        return element;
    }

    public WebElement confirm_btn() throws Exception{
        element = driver.findElement(objectmap.getLocator("confirm_btn"));
        return element;
    }

}
