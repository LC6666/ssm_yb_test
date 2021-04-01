package com.iebm.ssm.test;

import java.io.IOException;
import java.net.URISyntaxException;

import com.iebm.ssm.urlClient.DoRequest;



/**
 * @author Administrator
 * 天天基金获取基金净值信息
 *
 */
public class Eastmoney {
	
    
    public String searchMoney() throws IOException, URISyntaxException {
        String url = "http://fundgz.1234567.com.cn/js/110011.js?rt=1611370106633";
        String response = DoRequest.dogetWithCharset(url, null, null,"utf8");
        System.out.println(response);
        return response;

    }
    
    
    public static void main(String[] args) throws IOException, URISyntaxException {
    	Eastmoney money = new Eastmoney();
    	money.searchMoney();
	}

}
