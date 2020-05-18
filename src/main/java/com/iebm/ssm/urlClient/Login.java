package com.iebm.ssm.urlClient;


import com.iebm.ssm.util.Constant;
import com.iebm.ssm.util.MyCookieStore;

import org.apache.http.*;
import org.apache.http.message.BasicNameValuePair;
import org.testng.collections.Lists;

import java.io.*;
import java.net.URISyntaxException;
import java.util.List;

public class Login {


    public void openLoginPage() throws URISyntaxException, IOException {

        String url = Constant.url;
        DoRequest.doget(url, null, null);

    }


    public String loginURL() throws URISyntaxException, IOException, ClassNotFoundException {
//        构造路径参数

        /*List<NameValuePair> nameValuePairList1 = Lists.newArrayList();
        nameValuePairList1.add(new BasicNameValuePair("method","securityCodeImage"));
        nameValuePairList1.add(new BasicNameValuePair("seed","0.5791360342631169"));
        DoRequest.doget(Constant.url+"/loginAction.action", nameValuePairList1,MyCookieStore.readCookieStore("cookie"));*/



//        构造路径参数
        List<NameValuePair> nameValuePairList = Lists.newArrayList();
        nameValuePairList.add(new BasicNameValuePair("loginId",Constant.loginUsername));
        nameValuePairList.add(new BasicNameValuePair("password",Constant.loginPassword));
        nameValuePairList.add(new BasicNameValuePair("validateCode","1234"));
        String response = DoRequest.dopost(Constant.url+"/loginAction.action?method=login",nameValuePairList,MyCookieStore.readCookieStore("cookie"));
        return response;

    }






    public static void main(String[] args) throws ClassNotFoundException, IOException, URISyntaxException {
        Login login = new Login();
        login.loginURL();
    }


}
