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


    public void queryFeedBackCase(String index, String diseasename, String startdate, String enddate, String sicode, String accpet,String remark,String filepath, String enable) throws Exception {
        if (enable.equals("y")) {
            page.reset_btn().click();
            String diseasename_input_val = null;
            String startdata_input_val = null;
            String enddata_input_val = null;
            String sicode_input_val = null;
            if (diseasename != null && !diseasename.equals("")) {
                page.disease_img().click();
                Thread.sleep(300);
                DiseaseSelect_Action diseaseSelect_action = new DiseaseSelect_Action();
                diseaseSelect_action.finddisease(diseasename);
                diseasename_input_val = diseasename;
            }
            if (startdate != null && !startdate.equals("")) {
                UpdateAttribute.removeAttribute(Constant.driver, page.startdate_input(), "readonly");
                page.startdate_input().clear();
                page.startdate_input().sendKeys(startdate);
                startdata_input_val = startdate;
            }
            if (enddate != null && !enddate.equals("")) {
                UpdateAttribute.removeAttribute(Constant.driver, page.enddate_input(), "readonly");
                page.enddate_input().clear();
                page.enddate_input().sendKeys(enddate);
                enddata_input_val = enddate;
            }
            if (sicode != null && !sicode.equals("")) {
                page.sicode_input().sendKeys(sicode);
                sicode_input_val = sicode;
            }
            page.query_btn().click();

            Thread.sleep(500);

            int rowNum = 1;
//          遍历查询结果
            PageNumInfo pageInfo = new PageNumInfo(page.pageArea_table());
            String totalpageNo = pageInfo.getTotalPageNo();
            if (!totalpageNo.equals("0")) {

                if (sicode_input_val != null) {
                    //      根据sicode查找病例,遍历分页
                    String totalPageNo = pageInfo.getTotalPageNo();

                    for (int i = 1; i <= Integer.parseInt(totalPageNo); i++) {
                        Table table = new Table(page.resultlist_table());
                        int rowCount = table.getRowCount();

                        for (int j = 1; j < rowCount; j++) {
//                          获取表格中的病例号
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
                    //      任意选择某个病例(第一个病例)
                    Table table = new Table(page.resultlist_table());
                    table.getCell(rowNum, 3).click();
                    page.feedBack_btn().click();
//                Actions builder = new Actions(Constant.driver);
//                builder.doubleClick(table.getRow(rowNum));
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
//                    page.fileupload_btn().click();
                        page.fileupload_btn().sendKeys(filepath);
//                    page.fileupload_btn().sendKeys(filepath);
                        Constant.driver.switchTo().defaultContent();
                    }
//                Thread.sleep(1000);
//                提交
                    page.commit_btn().click();
//                确认
                    page.confirm_y_btn().click();
                    Thread.sleep(500);
                    page.tips_btn().click();
//                关闭
//                page.close_btn().click();

                }

            } else {
                System.out.println("没有查找到病例");
                return;
            }


            //                就诊编号为空，任意选择某一病例进行处理



        }

    }
}
