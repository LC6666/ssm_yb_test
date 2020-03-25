package com.iebm.ssm.util;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TreeSelector {

    private WebElement tree;

    public TreeSelector(WebElement tree){
        setTree(tree);
    }

    public WebElement getTree() {
        return tree;
    }

    public void setTree(WebElement tree) {
        this.tree = tree;
    }


    /**
     * 树型结构全部展开
     */
    public void expandTree(){
        Table table = new Table(this.getTree());
        List<WebElement> imgs = table.getWebElementsInTable(By.cssSelector("img[src $='plus3.gif']"));
        int size = imgs.size();
        if(size>0){
            for(int i=0;i<size;i++){
                imgs.get(i).click();
            }
            expandTree();
        }else {
            return;
        }

    }


    /**
     * 选择树结点
     * @param name
     */
    public void chooseTree(String name){
        Table table = new Table(this.getTree());
        List<WebElement> tds = table.getWebElementsInTable(By.tagName("span"));
//        List<WebElement> imgs = table.getWebElementsInTable(By.tagName("img"));
        for (int i=0;i<tds.size();i++){
            if(tds.get(i).getText().equals(name)){
                tds.get(i).click();
//                imgs.get(i).click();
            }
        }
    }







}
