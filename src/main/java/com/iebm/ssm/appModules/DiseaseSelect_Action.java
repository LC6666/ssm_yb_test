package com.iebm.ssm.appModules;

import com.iebm.ssm.pageObjects.DiseaseSelectPage;
import com.iebm.ssm.util.Constant;
import com.iebm.ssm.util.Table;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DiseaseSelect_Action {
    
    private DiseaseSelectPage page;


    public DiseaseSelect_Action() {
        page = new DiseaseSelectPage();
    }


    /**
     * @param diseasename
     * @throws Exception
     * @// TODO: 2019/1/11 使用关键字查询疾病
     */
    public void finddisease(String diseasename) throws Exception {
        Actions builder = new Actions(Constant.driver);
        page.diseasename_input().sendKeys(diseasename);
        page.diseasequery_btn().click();
        Thread.sleep(500);
        Table table = new Table(page.diseaselist());
        int rowCount = table.getRowCount();
        for (int i = 1; i < rowCount; i++) {
            WebElement cell = table.getCell(i, 3);
            if (diseasename.equals(cell.getText())) {
                builder.doubleClick(cell).build().perform();
                return;
            }


        }
    }



    public Boolean isFinddisease(String diseasename) throws Exception {
        if (diseasename != null) {
            page.diseasename_input().sendKeys(diseasename);
            page.diseasequery_btn().click();
            Table table = new Table(page.diseaselist());
            int rowCount = table.getRowCount();
            for (int i = 1; i < rowCount; i++) {
                WebElement cell = table.getCell(i, 3);
                if (diseasename.equals(cell.getText())) {
                    return true;
                }
            }
        }
        return false;
    }

}
