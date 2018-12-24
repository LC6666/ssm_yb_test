package com.iebm.ssm.util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/*
 *TODO
 *LC
 *下午5:20:42
 */

public class UpdateAttribute {

	public static void setAttribute(WebDriver driver,WebElement element,String attributeName,String value){
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute(arguments[1],arguments[2])", element,attributeName,value);

	}

	public static void removeAttribute(WebDriver driver,WebElement element,String attributeName){
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].removeAttribute(arguments[1],arguments[2])", element,attributeName);

	}

}



