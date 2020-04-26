package com.iebm.ssm.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.iebm.ssm.util.ObjectMap;

/*
 *TODO
 *LC
 *上午9:37:09
 */

public class QuestionDetailPage {

    private WebElement element = null;
    private ObjectMap  objectmap = new ObjectMap("questionDetailPageMap.properties");
    private WebDriver driver;

    public QuestionDetailPage(WebDriver driver) {
        // TODO Auto-generated constructor stub
        this.driver = driver;
    }

    public WebElement pagetitle() throws Exception{
        element = driver.findElement(objectmap.getLocator("ssm.questionDetail.pagetitle"));
        return element;
    }

    public WebElement pageclosebtn() throws Exception{
        element = driver.findElement(objectmap.getLocator("ssm.questionDetail.pageclosebtn"));
        return element;
    }

    public WebElement baseinfo() throws Exception {
        element = driver.findElement(objectmap.getLocator("ssm.questionDetail.baseinfo"));
        return element;
    }

    public WebElement totalFee() throws Exception{
        element = driver.findElement(objectmap.getLocator("ssm.questionDetail.totalFee"));
        return element;
    }

    public WebElement drugFee() throws Exception{
        element = driver.findElement(objectmap.getLocator("ssm.questionDetail.drugFee"));
        return element;
    }

    public WebElement inspectionFee() throws Exception{
        element = driver.findElement(objectmap.getLocator("ssm.questionDetail.inspectionFee"));
        return element;
    }

    public WebElement treatmentFee() throws Exception{
        element = driver.findElement(objectmap.getLocator("ssm.questionDetail.treatmentFee"));
        return element;
    }

    public WebElement otherFee() throws Exception{
        element = driver.findElement(objectmap.getLocator("ssm.questionDetail.otherFee"));
        return element;
    }

    public WebElement code() throws Exception{
        element = driver.findElement(objectmap.getLocator("ssm.questionDetail.code"));
        return element;
    }


    public WebElement chargeList() throws Exception{
        element = driver.findElement(objectmap.getLocator("ssm.questionDetail.chargeList"));
        return element;
    }

    public WebElement drugType() throws Exception{
        element = driver.findElement(objectmap.getLocator("ssm.questionDetail.chargeList.drugType"));
        return element;
    }

    public WebElement drugTable() throws Exception{
        element = driver.findElement(objectmap.getLocator("ssm.questionDetail.chargeList.drugTable"));
        return element;
    }

    public WebElement drugTotalPages() throws Exception{
        element = driver.findElement(objectmap.getLocator("ssm.questionDetail.chargeList.drugtable.totalPages"));
        return element;
    }

    public WebElement drugTableCurrentPage() throws Exception{
        element = driver.findElement(objectmap.getLocator("ssm.questionDetail.chargeList.drugtable.currentPage"));
        return element;
    }

    public WebElement drugTableNextPage() throws Exception{
        element = driver.findElement(objectmap.getLocator("ssm.questionDetail.chargeList.drugtable.nextPage"));
        return element;
    }


    public WebElement inspectionType() throws Exception{
        element = driver.findElement(objectmap.getLocator("ssm.questionDetail.chargeList.inspectionType"));
        return element;
    }

    public WebElement inspectionTable() throws Exception{
        element = driver.findElement(objectmap.getLocator("ssm.questionDetail.chargeList.inspectionTable"));
        return element;
    }

    public WebElement inspectionTotalPages() throws Exception{
        element = driver.findElement(objectmap.getLocator("ssm.questionDetail.chargeList.inspectiontable.totalPages"));
        return element;
    }

    public WebElement inspectionTableCurrentPage() throws Exception{
        element = driver.findElement(objectmap.getLocator("ssm.questionDetail.chargeList.inspectiontable.currentPage"));
        return element;
    }

    public WebElement inspectionTableNextPage() throws Exception{
        element = driver.findElement(objectmap.getLocator("ssm.questionDetail.chargeList.inspectiontable.nextPage"));
        return element;
    }

    public WebElement treatmentType() throws Exception{
        element = driver.findElement(objectmap.getLocator("ssm.questionDetail.chargeList.treatmentType"));
        return element;
    }

    public WebElement treatmentTable() throws Exception{
        element = driver.findElement(objectmap.getLocator("ssm.questionDetail.chargeList.treatmentTable"));
        return element;
    }

    public WebElement treatmentTotalPages() throws Exception{
        element = driver.findElement(objectmap.getLocator("ssm.questionDetail.chargeList.treatment.currentPage"));
        return element;
    }

    public WebElement treatmentTableCurrentPage() throws Exception{
        element = driver.findElement(objectmap.getLocator("ssm.questionDetail.chargeList.treatment.nextPage"));
        return element;
    }

    public WebElement treatmentTableNextPage() throws Exception{
        element = driver.findElement(objectmap.getLocator("ssm.questionDetail.chargeList.inspectiontable.nextPage"));
        return element;
    }


    public WebElement materialType() throws Exception{
        element = driver.findElement(objectmap.getLocator("ssm.questionDetail.chargeList.materialType"));
        return element;
    }

    public WebElement materialTable() throws Exception{
        element = driver.findElement(objectmap.getLocator("ssm.questionDetail.chargeList.materialTable"));
        return element;
    }

    public WebElement materialTotalPages() throws Exception{
        element = driver.findElement(objectmap.getLocator("ssm.questionDetail.chargeList.material.totalPages"));
        return element;
    }

    public WebElement materialTableCurrentPage() throws Exception{
        element = driver.findElement(objectmap.getLocator("ssm.questionDetail.chargeList.material.currentPage"));
        return element;
    }

    public WebElement materialTableNextPage() throws Exception{
        element = driver.findElement(objectmap.getLocator("ssm.questionDetail.chargeList.material.nextPage"));
        return element;
    }

    public WebElement otherType() throws Exception{
        element = driver.findElement(objectmap.getLocator("ssm.questionDetail.chargeList.otherType"));
        return element;
    }

    public WebElement otherTable() throws Exception{
        element = driver.findElement(objectmap.getLocator("ssm.questionDetail.chargeList.otherTable"));
        return element;
    }

    public WebElement otherTotalPages() throws Exception{
        element = driver.findElement(objectmap.getLocator("ssm.questionDetail.chargeList.other.totalPages"));
        return element;
    }

    public WebElement otherTableCurrentPage() throws Exception{
        element = driver.findElement(objectmap.getLocator("ssm.questionDetail.chargeList.other.currentPage"));
        return element;
    }

    public WebElement otherTableNextPage() throws Exception{
        element = driver.findElement(objectmap.getLocator("ssm.questionDetail.chargeList.other.nextPage"));
        return element;
    }






}



