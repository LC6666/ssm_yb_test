package com.iebm.ssm.appModules;

import com.iebm.ssm.pageObjects.UserConfigPage;
import com.iebm.ssm.util.Constant;
import com.iebm.ssm.util.PageNumInfo;
import com.iebm.ssm.util.Table;
import com.iebm.ssm.util.TreeSelector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Map;

import java.util.List;

public class UserConfig_Action {

    private UserConfigPage page;

    public UserConfig_Action(){

        page = new UserConfigPage(Constant.driver);
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

        page.userAddwindow_maxsize_btn().click();
        if (userInfo.get("loginId") != null) {
            page.add_loginId_input().sendKeys((String) userInfo.get("loginId"));
        }
        if (userInfo.get("name") != null) {
            page.add_name_input().sendKeys((String)userInfo.get("name"));
        }

        if (userInfo.get("displayName") != null) {
            page.add_displayName_input().click();
            if(!((String)userInfo.get("name")).equals((String)userInfo.get("displayName"))){
                page.add_displayName_input().click();
                page.add_displayName_input().clear();
                page.add_displayName_input().sendKeys((String)userInfo.get("displayName"));
            }

        }
        if (userInfo.get("postid") != null) {
            Select select = new Select(page.add_postid_option());
            select.selectByVisibleText((String)userInfo.get("postid"));
        }
        if (userInfo.get("officePhoneNO") != null) {
            page.add_officePhoneNO_input().sendKeys((String)userInfo.get("officePhoneNO"));
        }
        if (userInfo.get("mobilePhoneNO") != null) {
            page.add_mobilePhoneNO_input().sendKeys((String)userInfo.get("mobilePhoneNO"));
        }
        if (userInfo.get("email") != null) {
            page.add_email_input().sendKeys((String)userInfo.get("email"));
        }
        if (userInfo.get("faxNumber") != null) {
            page.add_faxNumber_input().sendKeys((String)userInfo.get("faxNumber"));
        }
        if (userInfo.get("bindIp") != null&&userInfo.get("bindIp") !="") {
            page.add_ipBindFlag_true().click();
            page.add_bindIp_input().sendKeys((String)userInfo.get("bindIp"));
        }
        if (userInfo.get("areaName") != null&&userInfo.get("areaName") !="") {
            page.add_areaId_img().click();
            TreeSelector tree = new TreeSelector(page.add_areaId_div());
            tree.expandTree();
            tree.chooseTree((String)userInfo.get("areaName"));
            page.add_areaConfirm_btn().click();
//            page.areaClose_btn().click();
        }
        if (userInfo.get("institution") != null&&userInfo.get("institution") !="") {
            page.add_institutionId_img().click();
            Thread.sleep(500);
            HospitalSelect_Action hospitalselect = new HospitalSelect_Action();
            hospitalselect.findHospital((String)userInfo.get("institution"));

        }

        if (userInfo.get("remark") != null) {
            page.add_remark_input().sendKeys((String)userInfo.get("remark"));
        }

        page.add_userAddsave_btn().click();
        Thread.sleep(500);
        String s = Constant.driver.getPageSource();
//        System.out.println(s);
        if(s.contains("操作成功")){
            System.out.println("用户"+userInfo.get("loginId")+"添加成功");
        }else{
            System.out.println("用户"+userInfo.get("loginId")+"添加失败");
        }
//        page.userAddMsg_btn().click();



    }


    public void editUser(String loginId) throws Exception {
        if(loginId!=null){

        }

        PageNumInfo pageNumInfo = new PageNumInfo(page.pageArea_table());
        String totalPageNo = pageNumInfo.getTotalPageNo();

        for(int pageNo=1;pageNo<=Integer.parseInt(totalPageNo);pageNo++){
            Table userList = new Table(page.userlist_table());
            int rowCount = userList.getRowCount();
            for(int i=1;i<rowCount;i++){
                userList.getRow(i).click();
                page.editUserBtn().click();
                Thread.sleep(300);

                String institutionname = page.edit_institution_input().getAttribute("value");
                String loginId2 = page.edit_loginId_input().getAttribute("value");
                if(institutionname==null||institutionname.equals("")){
                    System.out.println("用户"+loginId2+"没有绑定医疗机构");
                }
                page.edit_userClose_btn().click();
            }
            if(pageNo<Integer.parseInt(totalPageNo)){
                pageNumInfo.btnClick("next");
            }


        }



    }
}
