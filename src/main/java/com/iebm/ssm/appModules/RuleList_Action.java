package com.iebm.ssm.appModules;

import com.iebm.ssm.pageObjects.RuleListPage;
import com.iebm.ssm.util.Constant;
import com.iebm.ssm.util.PageNumInfo;
import com.iebm.ssm.util.Table;

/**
 * @Auther: LC
 * @Date: 2019/3/7 12:17
 * @Description: 规则列表页面操作
 */

public class RuleList_Action {

    private RuleListPage page;

    public RuleList_Action(){
        page = new RuleListPage(Constant.driver);

    }
    public void openPage() throws Exception {
        page.nav().click();
        page.title().click();
    }

    public boolean queryRule(String name) throws Exception {
        page.name_input().clear();
        page.name_input().sendKeys(name);
        page.query_btn().click();
        PageNumInfo pageinfo = new PageNumInfo(page.pageArea_table());

        String currentPageNo = pageinfo.getCurrentPageNo();
        String totalPage = pageinfo.getTotalPageNo();
        for(int i=1;i<=Integer.parseInt(totalPage);i++){
            Table table = new Table(page.rulelist_table());
            int rowCount = table.getRowCount();
            for(int j=1;j<rowCount;j++){
                String s = table.getCell(j, 2).getText();
                if(!s.contains(name)){
                   return false;
                }
            }
            if(pageinfo.getCurrentPageNo().equals(totalPage)){
                return true;
            }else{
                pageinfo.btnClick("next");
            }

        }
        return true;
    }


}
