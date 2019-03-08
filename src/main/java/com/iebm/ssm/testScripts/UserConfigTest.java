package com.iebm.ssm.testScripts;

import com.iebm.ssm.appModules.UserConfig_Action;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
/**
 *
 * 功能描述:
 *  用户管理
 * @auther: LC
 * @date: 2019/3/7 10:49
 */

public class UserConfigTest {

    private UserConfig_Action userConfig_action ;

    @Test(testName = "OpenPage",priority = 0)
    public void openPage() throws Exception {
        userConfig_action = new UserConfig_Action();
        userConfig_action.openPage();
    }

    @Test(testName = "选择组织机构",priority = 1,enabled = false)
    public void selectOrg() throws Exception {
        userConfig_action.selectOrg("铜川市医保,铜川市医保局,耀州医保局,铜川妇产医院");
    }

    @Test(testName = "AddUser",priority = 2,enabled = false)
    public void addUser()throws Exception {
        Map userInfo_map = new HashMap();
        String loginId = "testf";
        String name="测试";
        String displayName="测试";
        String postid=null;
        String officePhoneNO="87881021";
        String mobilePhoneNO="121111";
        String email="1111";
        String faxNumber="2222";
        String bindIp= "";
        String areaName="印台区";
        String institution= "长安医院";
        String remark="备注";

        userInfo_map.put("loginId", loginId);
        userInfo_map.put("name",name);
        userInfo_map.put("displayName",displayName);
        userInfo_map.put("postid",postid);
        userInfo_map.put("officePhoneNO",officePhoneNO);
        userInfo_map.put("mobilePhoneNO",mobilePhoneNO);
        userInfo_map.put("email",email);
        userInfo_map.put("faxNumber",faxNumber);
        userInfo_map.put("bindIp",bindIp);
        userInfo_map.put("areaName",areaName);
        userInfo_map.put("institution",institution);
        userInfo_map.put("remark",remark);

        userConfig_action.addUser(userInfo_map);
    }

    @Test(testName = "EditUser",priority = 3)
    public void editUser() throws Exception {
        userConfig_action.editUser(null);
    }
}
