package com.iebm.ssm.appModules;

import com.iebm.ssm.pageObjects.ExpertReviewPage;
import com.iebm.ssm.util.Constant;
import com.iebm.ssm.util.PageNumInfo;
import com.iebm.ssm.util.Table;
import com.iebm.ssm.util.UpdateAttribute;
import org.openqa.selenium.support.ui.Select;

/**
 * @Auther: LC
 * @Date: 2019/3/14 17:48
 * @Description:
 */

public class ExpertReview_Action {

    private ExpertReviewPage page;

    public ExpertReview_Action(){
        this.page = new ExpertReviewPage(Constant.driver);
    }

    public void openPage() throws Exception {
        page.nav().click();
        page.title().click();
    }

    public void queryReviewCase(String index, String hospital, String hospital_level, String disease, String illegalclass, String startdate, String enddate, String sicode, String accept, String remar, String enable) throws Exception {
        if(hospital!=null&&!hospital.equals("")){
            page.hospital_img().click();
            Thread.sleep(300);
            HospitalSelect_Action hospitalSelect_action = new HospitalSelect_Action();
            hospitalSelect_action.findHospital(hospital);

        }
        if(hospital_level!=null&&!disease.equals("")){
            Select select = new Select(page.hospital_level_select());
            select.selectByVisibleText(hospital_level);
        }
        if(disease!=null&&!disease.equals("")){
            page.disease_img().click();
            Thread.sleep(300);
            DiseaseSelect_Action diseaseSelect_action = new DiseaseSelect_Action();
            diseaseSelect_action.finddisease(disease);
        }
        if(startdate!=null&&!startdate.equals("")){
            UpdateAttribute.removeAttribute(Constant.driver, page.startdate_input(), "readonly");
            UpdateAttribute.removeAttribute(Constant.driver, page.enddate_input(), "readonly");
            page.startdate_input().clear();
            page.startdate_input().sendKeys(startdate);
            page.enddate_input().clear();
            page.enddate_input().sendKeys(enddate);
        }
        if(illegalclass!=null&&!illegalclass.equals("")){
            Select select = new Select(page.illegalClass_select());
            select.selectByVisibleText(illegalclass);
        }
        if(sicode!=null&&!sicode.equals("")){
            page.siCode_input().sendKeys(sicode);
        }
        page.query_btn().click();
        Thread.sleep(300);

        if(sicode!=null&&!sicode.equals("")){
            PageNumInfo pageInfo = new PageNumInfo(page.pageArea_table());
            String totalpageNo = pageInfo.getTotalPageNo();
            if (!totalpageNo.equals("0")) {
                //      根据sicode查找病例
                String totalPageNo = pageInfo.getTotalPageNo();
                pageSearch:
                for (int i = 1; i <= Integer.parseInt(totalPageNo); i++) {
                    Table table = new Table(page.resultlist_table());
                    int rowCount = table.getRowCount();

                    for (int j = 1; j < rowCount; j++) {
//                          获取表格中的病例号
                        String sicode_in_td = table.getCell(j, 2).getText();
                        if (sicode_in_td.equals(sicode)) {
                            System.out.println("找到病例");
                            break pageSearch;
                        }
                    }
                    if (i != Integer.parseInt(totalPageNo)) {
                        pageInfo.btnClick("next");
                        Thread.sleep(3000);
                    } else {
                        System.out.println("没有找到病例" + sicode);
                        return;
                    }

                }
            } else {
                System.out.println("没有找到病例" + sicode);
                return;
            }
        }
    }
}
