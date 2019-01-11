package com.iebm.ssm.util;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Iterator;
import java.util.List;

public class SelectOperate {

    private Select select;

    public SelectOperate(WebElement select){
        this.select = new Select(select);
    }

    public void operateSelectDemo(){
//        isMultiple表示此下拉列表是否允许多选
        select.isMultiple();
//        获取已选中的select的值
        select.getFirstSelectedOption().getText();
//        获取select下的所有选中的options，此方法适用多选操作
        List<WebElement> selectedoptions = select.getAllSelectedOptions();
        for(WebElement option:selectedoptions){
            System.out.println(option.getText());

        }
//        获取select下的所有选中的options
        List<WebElement> options = select.getOptions();
        for (WebElement option:options){
            System.out.println(option.getText());
        }

//        通过序列号来选择选项
        select.selectByIndex(3);
//通过选项值为选中
        select.selectByValue("08");
//通过显示文字来选中
        select.selectByVisibleText("乡镇卫生院");
    }
}
