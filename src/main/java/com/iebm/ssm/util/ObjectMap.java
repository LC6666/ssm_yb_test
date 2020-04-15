package com.iebm.ssm.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.openqa.selenium.By;

/*
 *TODO
 *Administrator
 *上午11:17:23
 */

public class ObjectMap {
    Properties properties;

    public ObjectMap(String propFile) {
        // TODO Auto-generated constructor stub
        properties = new Properties();

        try {
        	String propfile = Paths.get(System.getProperty("user.dir"), "pageFile/"+propFile).toString();
        	FileInputStream in = new FileInputStream(propfile);
//            FileInputStream in = new FileInputStream(propFile);
            properties.load(in);
            in.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("读取对象文件出错");
        }
    }


    public By getLocator(String ElementNameInpropFile) throws Exception{
//		根据变量 ElementNameInpropFile，从属性配置文件中读取对应的配置对象
        String locator = properties.getProperty(ElementNameInpropFile);
//		将配置对象中的定位类型存到locatorType变量，将定位表达式的值存入locatorValue变量
        String locatorType = locator.split(">")[0];
        String locatorValue = locator.split(">")[1];
//		字符转码，解决乱码问题
        locatorValue = new String(locatorValue.getBytes("ISO-8859-1"),"UTF-8");
//		System.out.println("获取的定位类型："+locatorType+"\t 获取的定位表达式："+locatorValue);


        if(locatorType.toLowerCase().equals("id")){
            return By.id(locatorValue);
        }else if(locatorType.toLowerCase().equals("name")){
            return By.name(locatorValue);
        }else if((locatorType.toLowerCase().equals("classname"))||(locatorType.toLowerCase().equals("class"))){
            return By.className(locatorValue);
        }else if((locatorType.toLowerCase().equals("tagname"))||(locatorType.toLowerCase().equals("tag"))){
            return By.tagName(locatorValue);
        }else if((locatorType.toLowerCase().equals("linktext"))||(locatorType.toLowerCase().equals("link"))){
            return By.linkText(locatorValue);
        }else if(locatorType.toLowerCase().equals("partiallinktext")){
            return By.partialLinkText(locatorValue);
        }else if((locatorType.toLowerCase().equals("cssselector"))||(locatorType.toLowerCase().equals("css"))){
            return By.cssSelector(locatorValue);
        }else if(locatorType.toLowerCase().equals("xpath")){
            return By.xpath(locatorValue);
        }else{
            throw new Exception("输入的locator type未在程序中被定义："+locatorType);
        }
    }








}



