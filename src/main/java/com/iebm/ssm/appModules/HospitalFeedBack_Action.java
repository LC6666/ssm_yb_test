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
        Thread.sleep(500);
        page.title().click();
    }

       
    /**
     * 根据病例号查找病例
     * @param index
     * @param disease
     * @param startdate
     * @param enddate
     * @param sicode
     * @param accpet
     * @param remark
     * @param filepath
     * @param enable
     * @throws Exception
     */
    public void queryCaseFeedBack(String index, String disease, String startdate, String enddate, String sicode, String accpet, String remark, String filepath, String enable) throws Exception {
//        if (enable.equals("true")) {
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
//                          获取表格中的病例
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

//        }


    }


       
    /**
     * 根据条件查找病例，并对病例进行医院回馈操作
     * @param index
     * @param diseasename
     * @param startdate
     * @param enddate
     * @param sicode
     * @param accpet
     * @param remark
     * @param filepath
     * @param enable
     * @throws Exception
     */
    public void queryCaseFeedBack2(String index, String diseasename, String startdate, String enddate, String sicode, String accpet, String remark, String filepath, String enable) throws Exception {
        if (enable.equals("y")) {
            page.reset_btn().click();

            if (diseasename != null && !diseasename.equals("")) {
                page.disease_img().click();
                Thread.sleep(300);
                DiseaseSelect_Action diseaseSelect_action = new DiseaseSelect_Action();
                diseaseSelect_action.finddisease(diseasename);

            }
            if (startdate != null && !startdate.equals("")) {
                UpdateAttribute.removeAttribute(Constant.driver, page.startdate_input(), "readonly");
                page.startdate_input().clear();
                page.startdate_input().sendKeys(startdate);
            }
            if (enddate != null && !enddate.equals("")) {
                UpdateAttribute.removeAttribute(Constant.driver, page.enddate_input(), "readonly");
                page.enddate_input().clear();
                page.enddate_input().sendKeys(enddate);
            }
            if (sicode != null && !sicode.equals("")) {
                page.sicode_input().sendKeys(sicode);
            }
            page.query_btn().click();
            Thread.sleep(3000);


            int rowNum = 1;
//          遍历查询结果
            PageNumInfo pageInfo = new PageNumInfo(page.pageArea_table());
            String totalpageNo = pageInfo.getTotalPageNo();
            if (!totalpageNo.equals("0")) {

                if (sicode != null && !sicode.equals("")) {
                    //      根据sicode查找病例,遍历分页
                    String totalPageNo = pageInfo.getTotalPageNo();

                    for (int i = 1; i <= Integer.parseInt(totalPageNo); i++) {
                        Table table = new Table(page.resultlist_table());
                        int rowCount = table.getRowCount();

                        for (int j = 1; j < rowCount; j++) {
//                          获取表格中的病例
                            String sicode_in_td = table.getCell(j, 2).getText();

                            if (sicode_in_td.equals(sicode)) {
//                                table.getRow(i).click();
//                                page.feedBack_btn().click();
                                rowNum = j;
                                break;
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
                }

                if (accpet != null && !accpet.equals("")) {
                    //      任意选择某个病例(第一个病)
                    Table table = new Table(page.resultlist_table());
                    table.getCell(rowNum, 3).click();
                    page.feedBack_btn().click();
                    Thread.sleep(500);
                    if (accpet.equals("y")) {
                        page.accept_btn().click();
                    } else {
                        page.noaccept_btn().click();
                    }

                    if (remark != null && !remark.equals("")) {
                        page.remark_text().sendKeys(remark);
                    }


                    if (filepath != null && !filepath.equals("")) {
                        Constant.driver.switchTo().frame("frm_img_2");
                        page.fileupload_btn().sendKeys(filepath);
                        Constant.driver.switchTo().defaultContent();
                    }
//                Thread.sleep(1000);
//                提交
                    page.commit_btn().click();
//               
                    page.confirm_y_btn().click();
                    Thread.sleep(500);
                    page.tips_btn().click();
                    Thread.sleep(1000);
//                关闭
//                page.close_btn().click();

                }

            } else {
                System.out.println("娌℃湁鏌ユ壘鍒扮梾渚�");
                return;
            }


            //                灏辫瘖缂栧彿涓虹┖锛屼换鎰忛�夋嫨鏌愪竴鐥呬緥杩涜澶勭悊



        }
    }
}
