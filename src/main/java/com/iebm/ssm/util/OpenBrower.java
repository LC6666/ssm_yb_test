package com.iebm.ssm.util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/*
 *TODO
 *LC
 *下午2:59:23
 */

public class OpenBrower {


    public static WebDriver openBrowser(String browser) {
        WebDriver driver = null;
        if (browser == null || browser.equals("")) {
            Log.error("未指定浏览器类型");
            return null;
        } else if (browser.equals("chrome")) {
            // chrome
            System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
            driver = new ChromeDriver();

        } else if (browser.equals("ie")) {
            // ie
            System.setProperty("webdriver.ie.driver", "./IEDriverServer.exe");
            driver = new InternetExplorerDriver();

        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }


    public static void closeBrowser(WebDriver driver){
        driver.close();
        driver.quit();
    }

}
