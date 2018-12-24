package com.iebm.ssm.appModules;

import java.math.BigDecimal;
import java.text.DecimalFormat;

import com.iebm.ssm.util.Constant;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.iebm.ssm.pageObjects.IllegalPage;
import com.iebm.ssm.pageObjects.QuestionDetailPage;
import com.iebm.ssm.util.Table;

/*
 *TODO
 *LC
 *上午9:45:07
 */

public class QuestionDetail_Action {

    private QuestionDetailPage page;

    private WebDriver driver;

    public QuestionDetail_Action() {
        // TODO Auto-generated constructor stub
        page = new QuestionDetailPage(Constant.driver);
    }

    /**
     * 基本信息验证
     * @throws Exception
     */

    public void getBaseInfo() throws Exception{

        page.pagetitle().click();
        Thread.sleep(500);
        page.baseinfo().click();

        String code = page.code().getAttribute("value");
        String totalFee_str = page.totalFee().getAttribute("value");
        String drugFee_str = page.drugFee().getAttribute("value");
        String inspectionFee_str = page.inspectionFee().getAttribute("value");
        String treatmentFee_str = page.treatmentFee().getAttribute("value");
        String otherFee_str = page.otherFee().getAttribute("value");
//		System.out.println("总费用="+totalFee_str+"   药品费用="+drugFee_str+"   检查费用="+inspectionFee_str+"   治疗费用="+treatmentFee_str+"   其他费用="+otherFee_str);
//		DecimalFormat  df   =new   DecimalFormat("#.0000");

        BigDecimal drugFee= drugFee_str.equals("")?BigDecimal.ZERO:new BigDecimal(drugFee_str);
        BigDecimal inspectionFee = inspectionFee_str.equals("")?BigDecimal.ZERO:new BigDecimal(inspectionFee_str);
        BigDecimal treatmentFee = treatmentFee_str.equals("")?BigDecimal.ZERO:new BigDecimal(treatmentFee_str);
        BigDecimal otherFee = otherFee_str.equals("")?BigDecimal.ZERO:new BigDecimal(otherFee_str);
        BigDecimal totalFee1 = totalFee_str.equals("")?BigDecimal.ZERO:new BigDecimal(totalFee_str);

        BigDecimal totalFee2 = inspectionFee.add(treatmentFee).add(otherFee).add(drugFee);
//		System.out.println("总费用="+totalFee2+"   药品费用="+drugFee+"   检查费用="+inspectionFee+"   治疗费用="+treatmentFee+"   其他费用="+otherFee);
        if(totalFee1.compareTo(totalFee2) ==0){
//			System.out.println("就诊编号:"+code+"总费用计算正确");
        }else{
            System.out.println("就诊编号:"+code+"总费用计算不正确");
        }

    }


    /**
     * 收费明细验证
     * @throws Exception
     */

    public void getChargeList() throws Exception{
        page.chargeList().click();
        Thread.sleep(1000);
//                药品费用计算
        page.drugType().click();
        Thread.sleep(500);
        BigDecimal alltotalprice = BigDecimal.ZERO;
        BigDecimal illegal_totalprice = BigDecimal.ZERO;

        int totalPages = Integer.parseInt(page.drugTotalPages().getText());
        for(int pageNum=1;pageNum<=totalPages;pageNum++){
            Thread.sleep(500);
            Table drugtable = new Table(page.drugTable());
            int RowCount = drugtable.getRowCount();
            for(int i=1;i<RowCount;i++){
                String price_str = drugtable.getCell(i, 11).getText();
                String num_str = drugtable.getCell(i, 12).getText();
                String type = drugtable.getCell(i, 14).getText();
//				System.out.println(price_str+"------"+num_str);
                BigDecimal price = new BigDecimal(price_str);
                BigDecimal num = new BigDecimal(num_str);
                BigDecimal totalprice = price.multiply(num);
                if(type.equals("疑似违规")){
                    illegal_totalprice = illegal_totalprice.add(totalprice);
//					System.out.println(illegalt_otalprice);
                }
                alltotalprice = alltotalprice.add(totalprice);
            }

            page.drugTableNextPage().click();
        }

		/*System.out.println(alltotalprice);
		System.out.println(illegal_totalprice);
		if(!(illegal_totalprice.compareTo( BigDecimal.ZERO)==0)){

		}
		System.out.println(alltotalprice+"---------------------"+page.drugFee().getAttribute("value"));*/
        if(!alltotalprice.toString().equals(page.drugFee().getAttribute("value"))){
            System.out.println("就诊编号:"+page.code().getAttribute("value")+"药品明细总费用计算不正确");
        }

//         检查费用计算



    }


}



