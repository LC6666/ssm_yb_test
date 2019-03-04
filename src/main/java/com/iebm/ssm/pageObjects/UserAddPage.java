package com.iebm.ssm.pageObjects;

import com.iebm.ssm.util.ObjectMap;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class UserAddPage {

    private WebElement element = null;
    private ObjectMap objectmap = new ObjectMap("./resource/userAddPageMap.properties");
    private WebDriver driver;

    public UserAddPage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement userAddwindow_maxsize_btn() throws Exception{
        List<WebElement> elementList = driver.findElements(objectmap.getLocator("userAddwindow_maxsize_btn"));
        return elementList.get(0);

    }

    public WebElement loginId_input() throws Exception {
        element = driver.findElement(objectmap.getLocator("loginId_input"));
        return element;
    }

    public WebElement name_input() throws Exception {
        element = driver.findElement(objectmap.getLocator("name_input"));
        return element;
    }

    public WebElement displayName_input() throws Exception {
        element = driver.findElement(objectmap.getLocator("displayName_input"));
        return element;
    }

    public WebElement postid_option() throws Exception{
        element = driver.findElement(objectmap.getLocator("postid_option"));
        return element;
    }

    public WebElement officePhoneNO_input() throws Exception {
        element = driver.findElement(objectmap.getLocator("officePhoneNO_input"));
        return element;
    }

    public WebElement mobilePhoneNO_input() throws Exception {
        element = driver.findElement(objectmap.getLocator("mobilePhoneNO_input"));
        return element;
    }

    public WebElement email_input() throws Exception {
        element = driver.findElement(objectmap.getLocator("email_input"));
        return element;
    }

    public WebElement faxNumber_input() throws Exception{
        element = driver.findElement(objectmap.getLocator("faxNumber_input"));
        return element;
    }

    public WebElement ipBindFlag_true() throws Exception {
        element = driver.findElement(objectmap.getLocator("ipBindFlag_true"));
        return element;
    }

    public WebElement ipBindFlag_false() throws Exception{
        element = driver.findElement(objectmap.getLocator("ipBindFlag_false"));
        return element;
    }

    public WebElement bindIp_input() throws Exception {
        element = driver.findElement(objectmap.getLocator("bindIp_input"));
        return element;
    }

    public WebElement areaId_img() throws Exception {
        element = driver.findElement(objectmap.getLocator("areaId_img"));
        return element;
    }

    public WebElement areaClose_btn() throws Exception {
        List<WebElement> elementList = driver.findElements(objectmap.getLocator("areaClose_btn"));
        return elementList.get(1);
    }

    public WebElement areaConfirm_btn() throws Exception {
        element = driver.findElement(objectmap.getLocator("areaConfirm_btn"));
        return element;
    }


    public WebElement areaId_div() throws Exception {
        element = driver.findElement(objectmap.getLocator("areaTree_div"));
        return element;
    }

    public WebElement institutionId_img() throws Exception {
        element = driver.findElement(objectmap.getLocator("institutionId_img"));
        return element;
    }

    public WebElement remark_input() throws Exception{
        element = driver.findElement(objectmap.getLocator("remark_input"));
        return element;
    }

    public WebElement userAddsave_btn() throws Exception {
        element = driver.findElement(objectmap.getLocator("userAddsave_btn"));
        return element;
    }

    public WebElement userAddreset_btn() throws Exception{
        element = driver.findElement(objectmap.getLocator("userAddreset_btn"));
        return element;
    }

    public WebElement userAddMsg_btn() throws Exception{
        element = driver.findElement(objectmap.getLocator("userAddMsg_btn"));
        return element;
    }
}
