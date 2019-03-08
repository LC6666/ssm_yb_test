package com.iebm.ssm.appModules;

import com.iebm.ssm.pageObjects.HospitalSelectPage;
import com.iebm.ssm.util.Constant;
import com.iebm.ssm.util.Table;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HospitalSelect_Action {

    private HospitalSelectPage page;


    public HospitalSelect_Action() {
        page = new HospitalSelectPage();
    }


    /**
     * @param hospitalname
     * @throws Exception
     * @// TODO: 2019/1/11 使用关键字查询医院
     */
    public void findHospital(String hospitalname) throws Exception {
        Actions builder = new Actions(Constant.driver);
        page.hospitalname_input().sendKeys(hospitalname);
        page.hospitalquery_btn().click();
        Table table = new Table(page.hospitallist());
        int rowCount = table.getRowCount();
        for (int i = 1; i < rowCount; i++) {
            WebElement cell = table.getCell(i, 4);
            if (hospitalname.equals(cell.getText())) {
                builder.doubleClick(cell).build().perform();
                return;
            }


        }
    }


    /**
     * 验证返回选项是否包含输入的信息
     * @param hospitalname
     * @return
     * @throws Exception
     */
    public Boolean isFindHospital(String hospitalname) throws Exception {
        if (hospitalname != null) {
            page.hospitalname_input().clear();
            page.hospitalname_input().sendKeys(hospitalname);
            page.hospitalquery_btn().click();
            Table table = new Table(page.hospitallist());
            int rowCount = table.getRowCount();
            for (int i = 1; i < rowCount; i++) {
                WebElement cell = table.getCell(i, 4);
                if (hospitalname.equals(cell.getText())) {
                    page.hospitalcancel_btn().click();
                    return true;
                }
            }

        }
        page.hospitalcancel_btn().click();
        return false;
    }

}
