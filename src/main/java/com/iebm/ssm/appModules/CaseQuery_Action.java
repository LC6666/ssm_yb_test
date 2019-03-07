package com.iebm.ssm.appModules;

import java.util.HashMap;
import java.util.Map;

import com.iebm.ssm.util.Constant;
import com.iebm.ssm.util.PageNumInfo;
import com.iebm.ssm.util.Table;
import com.iebm.ssm.util.UpdateAttribute;
import org.openqa.selenium.WebDriver;

import com.iebm.ssm.pageObjects.CaseQueryPage;
import org.openqa.selenium.support.ui.Select;

/*
 *TODO
 *LC
 *下午5:02:39
 */

public class CaseQuery_Action {

    private CaseQueryPage page;

    public CaseQuery_Action() {
        // TODO Auto-generated constructor stub
        page = new CaseQueryPage(Constant.driver);
    }

    /**
     *
     * @throws Exception
     * TODO 进入疑点查询页面
     * LC
     * 上午10:34:30
     */
    public void openPage() throws Exception {

        page.nav().click();
        Thread.sleep(300);
        page.title().click();
    }


    public void query(String hospital,String hospital_level,String disease,String startdate,String enddate,String sicode,String insuredName) throws Exception {
        page.reset_btn().click();
        if(hospital!=null) {
            page.hospital_img().click();
            HospitalSelect_Action hospitalSelect_action = new HospitalSelect_Action();
            hospitalSelect_action.findHospital(hospital);
        }
        if(hospital_level!=null){
            Select select = new Select(page.hospital_level_select());
            select.selectByVisibleText(hospital_level);

        }
        if(disease!=null){
            page.disease_img().click();
            DiseaseSelect_Action diseaseSelect_action = new DiseaseSelect_Action();
            diseaseSelect_action.finddisease(disease);
        }

        if(startdate!=null){
            UpdateAttribute.removeAttribute(Constant.driver, page.startdate_input(), "readonly");
            page.startdate_input().clear();
            page.startdate_input().sendKeys(startdate);
        }
        if(enddate!=null){
            UpdateAttribute.removeAttribute(Constant.driver, page.enddate_input(), "readonly");
            page.enddate_input().clear();
            page.enddate_input().sendKeys(startdate);
        }

        if(sicode!=null){
            page.siCode_input().sendKeys(sicode);
        }

        if(insuredName!=null){
            page.insuredName_input().sendKeys(insuredName);
        }
        page.query_btn().click();
        Thread.sleep(3000);

        PageNumInfo pageInfo = new PageNumInfo(page.pageArea_table());

        String totalPageNo = pageInfo.getTotalPageNo();

        for(int i=1;i<=Integer.parseInt(totalPageNo);i++){
            Table table = new Table(page.resultlist_table());
            int rowCount = table.getRowCount();
            for(int j=1;j<rowCount;j++){
//                打印每行的疾病
                System.out.println(table.getCell(j, 6).getText());
            }
            if(i!=Integer.parseInt(totalPageNo)){
                pageInfo.btnClick("next");
                Thread.sleep(3000);
            }else{
                return;
            }

        }


    }





}



