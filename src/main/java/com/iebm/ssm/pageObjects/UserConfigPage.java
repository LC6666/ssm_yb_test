package com.iebm.ssm.pageObjects;

import com.iebm.ssm.util.ObjectMap;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class UserConfigPage {

    private WebElement element = null;
    private ObjectMap objectmap = new ObjectMap("userConfigPageMap.properties");
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

    public WebElement userlist_table() throws Exception{
        element = driver.findElement(objectmap.getLocator("userlist_table"));
        return element;
    }

    public WebElement pageArea_table() throws Exception{
        element = driver.findElement(objectmap.getLocator("pageArea_table"));
        return element;
    }

    public WebElement editUserBtn() throws Exception{
        element = driver.findElement(objectmap.getLocator("editUserBtn"));
        return element;
    }

//    -----------start---------新增用户------------------------
    public WebElement userAddwindow_maxsize_btn() throws Exception{
        List<WebElement> elementList = driver.findElements(objectmap.getLocator("userAddwindow_maxsize_btn"));
        return elementList.get(0);

    }

    public WebElement add_loginId_input() throws Exception {
        element = driver.findElement(objectmap.getLocator("Add_loginId_input"));
        return element;
    }

    public WebElement add_name_input() throws Exception {
        element = driver.findElement(objectmap.getLocator("Add_name_input"));
        return element;
    }

    public WebElement add_displayName_input() throws Exception {
        element = driver.findElement(objectmap.getLocator("Add_displayName_input"));
        return element;
    }

    public WebElement add_postid_option() throws Exception{
        element = driver.findElement(objectmap.getLocator("Add_postid_option"));
        return element;
    }

    public WebElement add_officePhoneNO_input() throws Exception {
        element = driver.findElement(objectmap.getLocator("Add_officePhoneNO_input"));
        return element;
    }

    public WebElement add_mobilePhoneNO_input() throws Exception {
        element = driver.findElement(objectmap.getLocator("Add_mobilePhoneNO_input"));
        return element;
    }

    public WebElement add_email_input() throws Exception {
        element = driver.findElement(objectmap.getLocator("Add_email_input"));
        return element;
    }

    public WebElement add_faxNumber_input() throws Exception{
        element = driver.findElement(objectmap.getLocator("Add_faxNumber_input"));
        return element;
    }

    public WebElement add_ipBindFlag_true() throws Exception {
        element = driver.findElement(objectmap.getLocator("Add_ipBindFlag_true"));
        return element;
    }

    public WebElement add_ipBindFlag_false() throws Exception{
        element = driver.findElement(objectmap.getLocator("Add_ipBindFlag_false"));
        return element;
    }

    public WebElement add_bindIp_input() throws Exception {
        element = driver.findElement(objectmap.getLocator("Add_bindIp_input"));
        return element;
    }

    public WebElement add_areaId_img() throws Exception {
        element = driver.findElement(objectmap.getLocator("Add_areaId_img"));
        return element;
    }

    public WebElement add_areaClose_btn() throws Exception {
        List<WebElement> elementList = driver.findElements(objectmap.getLocator("Add_areaClose_btn"));
        return elementList.get(1);
    }

    public WebElement add_areaConfirm_btn() throws Exception {
        element = driver.findElement(objectmap.getLocator("Add_areaConfirm_btn"));
        return element;
    }


    public WebElement add_areaId_div() throws Exception {
        element = driver.findElement(objectmap.getLocator("Add_areaTree_div"));
        return element;
    }

    public WebElement add_institutionId_img() throws Exception {
        element = driver.findElement(objectmap.getLocator("Add_institutionId_img"));
        return element;
    }

    public WebElement add_remark_input() throws Exception{
        element = driver.findElement(objectmap.getLocator("Add_remark_input"));
        return element;
    }

    public WebElement add_userAddsave_btn() throws Exception {
        element = driver.findElement(objectmap.getLocator("Add_userAddsave_btn"));
        return element;
    }

    public WebElement add_userAddreset_btn() throws Exception{
        element = driver.findElement(objectmap.getLocator("Add_userAddreset_btn"));
        return element;
    }

    public WebElement add_userAddMsg_btn() throws Exception{
        element = driver.findElement(objectmap.getLocator("Add_userAddMsg_btn"));
        return element;
    }
    //    -----------end---------新增用户------------------------


//    --------------------start-----编辑用户-------------------------------

    public WebElement edit_loginId_input() throws Exception{
        element = driver.findElement(objectmap.getLocator("Edit_loginId_input"));
        return element;
    }
    public WebElement edit_name_input() throws Exception{
        element = driver.findElement(objectmap.getLocator("Edit_name_input"));
        return element;
    }
    public WebElement edit_employeeNO_input() throws Exception{
        element = driver.findElement(objectmap.getLocator("Edit_employeeNO_input"));
        return element;
    }
    public WebElement edit_displayName_input() throws Exception{
        element = driver.findElement(objectmap.getLocator("Edit_displayName_input"));
        return element;
    }
    public WebElement edit_sex_select() throws Exception{
        element = driver.findElement(objectmap.getLocator("Edit_sex_select"));
        return element;
    }
    public WebElement edit_postid_option() throws Exception{
        element = driver.findElement(objectmap.getLocator("Edit_postid_option"));
        return element;
    }
    public WebElement edit_officePhoneNO_input() throws Exception{
        element = driver.findElement(objectmap.getLocator("Edit_officePhoneNO_input"));
        return element;
    }
    public WebElement edit_mobilePhoneNO_input() throws Exception{
        element = driver.findElement(objectmap.getLocator("Edit_mobilePhoneNO_input"));
        return element;
    }
    public WebElement edit_email_input() throws Exception{
        element = driver.findElement(objectmap.getLocator("Edit_email_input"));
        return element;
    }
    public WebElement edit_faxNumber_input() throws Exception{
        element = driver.findElement(objectmap.getLocator("Edit_faxNumber_input"));
        return element;
    }
    public WebElement edit_ipBindFlag_true() throws Exception{
        element = driver.findElement(objectmap.getLocator("Edit_ipBindFlag_true"));
        return element;
    }
    public WebElement edit_ipBindFlag_false() throws Exception{
        element = driver.findElement(objectmap.getLocator("Edit_ipBindFlag_false"));
        return element;
    }
    public WebElement edit_bindIp_input() throws Exception{
        element = driver.findElement(objectmap.getLocator("Edit_bindIp_input"));
        return element;
    }
    public WebElement edit_orgName_input() throws Exception{
        element = driver.findElement(objectmap.getLocator("Edit_orgName_input"));
        return element;
    }
    public WebElement edit_orgName_img() throws Exception{
        element = driver.findElement(objectmap.getLocator("Edit_orgName_img"));
        return element;
    }
    public WebElement edit_areaId_input() throws Exception{
        element = driver.findElement(objectmap.getLocator("Edit_areaId_input"));
        return element;
    }

    public WebElement edit_areaId_img() throws Exception{
        element = driver.findElement(objectmap.getLocator("Edit_areaId_img"));
        return element;
    }
    public WebElement edit_areaTree_div() throws Exception{
        element = driver.findElement(objectmap.getLocator("Edit_areaTree_div"));
        return element;
    }
    public WebElement edit_areaClose_btn() throws Exception{
        element = driver.findElement(objectmap.getLocator("Edit_areaClose_btn"));
        return element;
    }
    public WebElement edit_areaConfirm_btn() throws Exception{
        element = driver.findElement(objectmap.getLocator("Edit_areaConfirm_btn"));
        return element;
    }
    public WebElement edit_institutionId_img() throws Exception{
        element = driver.findElement(objectmap.getLocator("Edit_institutionId_img"));
        return element;
    }
    public WebElement edit_institution_input() throws Exception{
        element = driver.findElement(objectmap.getLocator("Edit_institution_input"));
        return element;
    }
    public WebElement edit_insurance_input() throws Exception{
        element = driver.findElement(objectmap.getLocator("Edit_insurance_input"));
        return element;
    }
    public WebElement edit_insurance_img() throws Exception{
        element = driver.findElement(objectmap.getLocator("Edit_insurance_img"));
        return element;
    }

    public WebElement edit_remark_input() throws Exception{
        element = driver.findElement(objectmap.getLocator("Edit_remark_input"));
        return element;
    }
    public WebElement edit_userEditsave_btn() throws Exception{
        element = driver.findElement(objectmap.getLocator("Edit_userEditsave_btn"));
        return element;
    }
    public WebElement edit_userEditreset_btn() throws Exception{
        element = driver.findElement(objectmap.getLocator("Edit_userEditreset_btn"));
        return element;
    }
    public WebElement edit_userEditMsg_btn() throws Exception{
        element = driver.findElement(objectmap.getLocator("Edit_userEditMsg_btn"));
        return element;
    }

    public WebElement edit_userClose_btn() throws Exception {
        element = driver.findElement(objectmap.getLocator("Edit_userClose_btn"));
        return element;
    }

    //    --------------------end-----编辑用户-------------------------------
}
