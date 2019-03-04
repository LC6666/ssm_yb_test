package com.iebm.ssm.appModules;

import com.iebm.ssm.pageObjects.UserAddPage;
import com.iebm.ssm.pageObjects.UserConfigPage;
import com.iebm.ssm.util.Constant;
import com.iebm.ssm.util.Table;
import com.iebm.ssm.util.TreeSelector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.Map;

import java.util.List;

public class UserConfig_Action {

    private UserConfigPage page;
    private UserAddPage addpage;

    public UserConfig_Action(){

        page = new UserConfigPage(Constant.driver);
        addpage = new UserAddPage(Constant.driver);
    }

    public void openPage() throws Exception {
        page.nav().click();
        page.title().click();
    }

    /**
     * 选择组织机构
     * @param orgName
     * @throws Exception
     */
    public void selectOrg(String orgName) throws Exception {
        if(orgName!=null&&!orgName.isEmpty()){
            String[] names = orgName.split(",");
            int names_len = names.length;
            expandTree();
            Table tree_table = new Table(page.orgTreeTable());
            List<WebElement> tds = tree_table.getWebElementsInTable(By.tagName("span"));
            String tree_org ="";
            for(int i=0;i<tds.size();i++ ){
                tree_org = tds.get(i).getText();
                if(tree_org.equals(names[names_len-1])){
                    tds.get(i).click();
                    return;
                }
            }
        }
    }


    /**
     * 将组织机构树的所有节点展开
     * @throws Exception
     */
    public void expandTree() throws Exception {
        Table tree_table = new Table(page.orgTreeTable());
        List<WebElement> imgs = tree_table.getWebElementsInTable(By.cssSelector("img[src $='plus3.gif']"));
        if(imgs.size()>0){
            for(int i=0;i<imgs.size();i++){
                imgs.get(i).click();
            }
            expandTree();
        }else{
            return;
        }
    }

    public void addUser(Map userInfo) throws Exception {
        page.addUserBtn().click();

        addpage.userAddwindow_maxsize_btn().click();
        if (userInfo.get("loginId") != null) {
            addpage.loginId_input().sendKeys((String) userInfo.get("loginId"));
        }
        if (userInfo.get("name") != null) {
            addpage.name_input().sendKeys((String)userInfo.get("name"));
        }

        if (userInfo.get("displayName") != null) {
            addpage.displayName_input().click();
            if(!((String)userInfo.get("name")).equals((String)userInfo.get("displayName"))){
                addpage.displayName_input().click();
                addpage.displayName_input().clear();
                addpage.displayName_input().sendKeys((String)userInfo.get("displayName"));
            }

        }
        if (userInfo.get("postid") != null) {
            Select select = new Select(addpage.postid_option());
            select.selectByVisibleText((String)userInfo.get("postid"));
        }
        if (userInfo.get("officePhoneNO") != null) {
            addpage.officePhoneNO_input().sendKeys((String)userInfo.get("officePhoneNO"));
        }
        if (userInfo.get("mobilePhoneNO") != null) {
            addpage.mobilePhoneNO_input().sendKeys((String)userInfo.get("mobilePhoneNO"));
        }
        if (userInfo.get("email") != null) {
            addpage.email_input().sendKeys((String)userInfo.get("email"));
        }
        if (userInfo.get("faxNumber") != null) {
            addpage.faxNumber_input().sendKeys((String)userInfo.get("faxNumber"));
        }
        if (userInfo.get("bindIp") != null&&userInfo.get("bindIp") !="") {
            addpage.ipBindFlag_true().click();
            addpage.bindIp_input().sendKeys((String)userInfo.get("bindIp"));
        }
        if (userInfo.get("areaName") != null&&userInfo.get("areaName") !="") {
            addpage.areaId_img().click();
            TreeSelector tree = new TreeSelector(addpage.areaId_div());
            tree.expandTree();
            tree.chooseTree((String)userInfo.get("areaName"));
            addpage.areaConfirm_btn().click();
//            addpage.areaClose_btn().click();
        }
        if (userInfo.get("institution") != null&&userInfo.get("institution") !="") {
            addpage.institutionId_img().click();
            Thread.sleep(500);
            HospitalSelect_Action hospitalselect = new HospitalSelect_Action();
            hospitalselect.findHospital((String)userInfo.get("institution"));

        }

        if (userInfo.get("remark") != null) {
            addpage.remark_input().sendKeys((String)userInfo.get("remark"));
        }

        addpage.userAddsave_btn().click();
        Thread.sleep(500);
        String s = Constant.driver.getPageSource();
//        System.out.println(s);
        if(s.contains("操作成功")){
            System.out.println("用户"+userInfo.get("loginId")+"添加成功");
        }else{
            System.out.println("用户"+userInfo.get("loginId")+"添加失败");
        }
//        addpage.userAddMsg_btn().click();



    }


}
