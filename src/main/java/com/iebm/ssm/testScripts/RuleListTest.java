package com.iebm.ssm.testScripts;

import com.iebm.ssm.appModules.RuleList_Action;
import com.iebm.ssm.util.PageNumInfo;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @Auther: LC
 * @Date: 2019/3/7 12:16
 * @Description: 规则列表
 */

public class RuleListTest {

    private RuleList_Action ruleList_action;


    @Test(testName = "openRuleListPage",priority = 0)
    public void openPage() throws Exception {
        ruleList_action = new RuleList_Action();
        ruleList_action.openPage();
        Thread.sleep(500);
    }


    @Test(testName = "queryRule",priority = 1)
    public void queryRule() throws Exception {
        boolean b = ruleList_action.queryRule("门诊");
        Assert.assertTrue(b);
    }

}
