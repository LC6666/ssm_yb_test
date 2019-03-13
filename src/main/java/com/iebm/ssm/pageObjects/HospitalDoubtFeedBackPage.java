package com.iebm.ssm.pageObjects;

import com.iebm.ssm.util.ObjectMap;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * 医院疑似违规病例反馈
 * @Auther: LC
 * @Date: 2019/3/12 13:12
 * @Description:
 */

public class HospitalDoubtFeedBackPage {

    private WebElement element = null;
    private ObjectMap objectmap = new ObjectMap("./resource/hospitalFeedBackPageMap.properties");
    private WebDriver driver;

    public HospitalDoubtFeedBackPage(WebDriver driver) {
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
    public WebElement feedBack_btn() throws Exception{
        element = driver.findElement(objectmap.getLocator("feedBack_btn"));
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
    public WebElement accept_btn() throws Exception{
        element = driver.findElement(objectmap.getLocator("accept_btn"));
        return element;
    }
    public WebElement noaccept_btn() throws Exception{
        element = driver.findElement(objectmap.getLocator("noaccept_btn"));
        return element;
    }
    public WebElement remark_text() throws Exception{
        element = driver.findElement(objectmap.getLocator("remark_text"));
        return element;
    }
    public WebElement fileupload_btn() throws Exception{
        element = driver.findElement(objectmap.getLocator("fileupload_btn"));
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

    public WebElement confirm_y_btn() throws Exception{
        List<WebElement> elements = driver.findElements(objectmap.getLocator("confirm_y_btn"));
        return elements.get(0);
    }
    public WebElement confirm_n_btn() throws Exception{
        List<WebElement> elements = driver.findElements(objectmap.getLocator("confirm_n_btn"));
        return elements.get(1);
    }



}
