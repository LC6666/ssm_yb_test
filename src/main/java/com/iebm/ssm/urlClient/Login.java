package com.iebm.ssm.urlClient;

import com.google.common.collect.Lists;
import com.iebm.ssm.testScripts.LoginTest;
import com.iebm.ssm.util.Constant;
import org.apache.http.*;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.*;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.*;
import java.net.URI;
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
