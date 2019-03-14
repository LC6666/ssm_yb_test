package com.iebm.ssm.appModules;

import com.iebm.ssm.pageObjects.HospitalFeedBackPage;
import com.iebm.ssm.util.Constant;
import com.iebm.ssm.util.PageNumInfo;
import com.iebm.ssm.util.Table;
import com.iebm.ssm.util.UpdateAttribute;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

/**
 * @Auther: LC
 * @Date: 2019/3/12 13:26
 * @Description:
 */

public class HospitalFeedBack_Action {

    private HospitalFeedBackPage page;

    public HospitalFeedBack_Action() {
        this.page = new HospitalFeedBackPage(Constant.driver);
    }

    public void openPage() throws Exception {
        page.nav().click();
        page.title().click();
    }

    public void queryCaseFeedBack(String index, String diseasename, String startdate, String enddate, String sicode, String accpet, String remark, String filepath, String enable) throws Exception {
        if (enable.equals("true")) {
            if (diseasename != null && !diseasename.equals("")) {
                page.disease_img().click();
                Thread.sleep(300);
                DiseaseSelect_Action diseaseSelect_action = new DiseaseSelect_Action();
                diseaseSelect_action.finddisease(diseasename);
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

    public void queryCaseToFeedBace(String index, String diseasename, String startdate, String enddate, String sicode, String accpet, String remark, String filepath, String enable) throws Exception {
        if (enable.equals("true")) {
            if (diseasename != null && !diseasename.equals("")) {
                page.disease_img().click();
                Thread.sleep(300);
                DiseaseSelect_Action diseaseSelect_action = new DiseaseSelect_Action();
                diseaseSelect_action.finddisease(diseasename);
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
                                table.getRow(i).click();
                                page.feedBack_btn().click();
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

            } else {
                //      任意选择某个病例(第一个病例)
                Table table = new Table(page.resultlist_table());
                Actions builder = new Actions(Constant.driver);
                builder.doubleClick(table.getRow(2));
            }

            if (accpet.equals("n")) {
                page.accept_btn().click();
            } else {
                page.noaccept_btn().click();
            }
            if (remark != null) {
                page.remark_text().sendKeys(remark);
            }


            if (filepath != null) {
                page.fileupload_btn().click();
            }

            page.commit_btn().click();
            page.confirm_y_btn().click();

        }
    }
}
