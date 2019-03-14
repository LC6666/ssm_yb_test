package com.iebm.ssm.appModules;

import com.iebm.ssm.pageObjects.HospitalDoubtFeedBackPage;
import com.iebm.ssm.util.Constant;
import com.iebm.ssm.util.PageNumInfo;
import com.iebm.ssm.util.Table;
import com.iebm.ssm.util.UpdateAttribute;

/**
 * @Auther: LC
 * @Date: 2019/3/14 10:05
 * @Description:
 */

public class HospitalDoubtFeedBack_Action {
    private HospitalDoubtFeedBackPage page;

    public HospitalDoubtFeedBack_Action(){
        page = new HospitalDoubtFeedBackPage(Constant.driver);
    }

    public void openPage() throws Exception {
        page.nav().click();
        page.title().click();
        Thread.sleep(500);
    }


    public void queryFeedBackCase(String index, String disease, String startdate, String enddate, String sicode, String accpet, String filepath, String enable) throws Exception {
        if (enable.equals("true")) {
            if (disease != null && !disease.equals("")) {
                page.disease_img().click();
                Thread.sleep(300);
                DiseaseSelect_Action diseaseSelect_action = new DiseaseSelect_Action();
                diseaseSelect_action.finddisease(disease);
            }
            if (startdate != null) {
                UpdateAttribute.removeAttribute(Constant.driver, page.startdate_input(), "readonly");
                page.startdate_input().clear();
                page.startdate_input().sendKeys(startdate);
            }
            if (enddate != null) {
                UpdateAttribute.removeAttribute(Constant.driver, page.enddate_input(), "readonly");
                page.enddate_input().clear();
                page.enddate_input().sendKeys(enddate);
            }
            page.query_btn().click();
            Thread.sleep(500);
            if (sicode != null) {

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
}
