package com.iebm.ssm.util;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/*
 *TODO
 *LC
 *下午8:16:26
 */

public class Table {

    private WebElement _table;

    public Table(WebElement table){
        setTable(table);
    }

    public void setTable(WebElement _table) {
        // TODO Auto-generated method stub
        this._table = _table;
    }

    public WebElement getTable(){
        return _table;
    }


    /**
     * 获取表格元素的行数，查找表格元素有几个tr元素（不适用于table中有嵌套table的情形）
     * 有几个tr元素，就可以知道表格有几行，tr数量和表格行数一致
     * @return
     * TODO
     * LC
     * 下午7:51:32
     */
    public int getRowCount(){
        List<WebElement> tableRows = _table.findElements(By.tagName("tr"));
        return tableRows.size();
    }



    /**
     * 获取表格的列数（不适用于table中有嵌套table的情形）
     * 使用get(0)从容器中取出表格第一行的元素，查找有几个"td"，td数量和列数一致
     * @return
     * TODO
     * LC
     * 下午7:54:14
     */
    public int getColumnCount(){
        List<WebElement> tableRows = _table.findElements(By.tagName("tr"));
//		第1行为th，从第2行为td比较稳定
        return tableRows.get(tableRows.size()-1).findElements(By.tagName("td")).size();
    }


    /**
     * 获取表格某一行内容（不适用于table中有嵌套table的情形）
     * @param RowNum
     * @return
     */
    public WebElement getRow(int RowNum){
        try {
            List<WebElement> tableRows = _table.findElements(By.tagName("tr"));
            WebElement currentRow = tableRows.get(RowNum);
            return currentRow;
        } catch (NoSuchElementException e) {
            // TODO Auto-generated catch block
            throw new NoSuchElementException("没有找到相关元素");
        }
    }




    /**
     * 获取表格中某行某列的单元格对象
     * @param rowNo
     * @param colNo
     * @return
     * TODO
     * LC
     * 下午7:55:46
     */
    public WebElement getCell(int rowNo,int colNo){
        try {
            List<WebElement> tableRows = _table.findElements(By.tagName("tr"));
            WebElement currentRow = tableRows.get(rowNo);
            List<WebElement> tablecols = currentRow.findElements(By.tagName("td"));
            WebElement cell = tablecols.get(colNo);
            return cell;
        } catch (NoSuchElementException e) {
            // TODO Auto-generated catch block
            throw new NoSuchElementException("没有找到相关元素");
        }

    }

    /**
     * 获得表格中某行某列的单元格中的某个页面元素对象，by参数用于定位某个表格中的页面元素，如by.xpath("iniput[@type='text']")可以定义到表格中的输入框
     * @param rowNo
     * @param colNo
     * @param by
     * @return
     * TODO
     * LC
     * 下午7:56:11
     */
    public WebElement getWebElementInCell(int rowNo,int colNo,By by){
        try {
            List<WebElement> tableRows = _table.findElements(By.tagName("tr"));
            WebElement currentRow = tableRows.get(rowNo);
            List<WebElement> tablecols = currentRow.findElements(By.tagName("td"));

            WebElement cell = tablecols.get(colNo);
            return cell.findElement(by);
        } catch (NoSuchElementException e) {
            // TODO Auto-generated catch block
            throw new NoSuchElementException("没有找到相关元素");
        }
    }


    /**
     * 获得表格中某个元素的数量，如表格中嵌套图片
     * @param by
     * @return
     * TODO
     * LC
     * 下午7:56:11
     */
    public List<WebElement> getWebElementsInTable(By by){
        try {
            return _table.findElements(by);
        } catch (NoSuchElementException e) {
            // TODO Auto-generated catch block
            throw new NoSuchElementException("没有找到相关元素");
        }
    }


    /**
     * 获取某一列
     * @param colNo
     * @return
     */
    public List<WebElement> getColum(int colNo){
        List<WebElement> list = new ArrayList<>();
        for(int i=0;i<getRowCount();i++){
            WebElement element = this.getRow(i).findElements(By.className("td")).get(colNo);
            list.add(element);
        }
       return list;
    }


}



