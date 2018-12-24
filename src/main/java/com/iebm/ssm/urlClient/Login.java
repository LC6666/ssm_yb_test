package com.iebm.ssm.urlClient;

import com.google.common.collect.Lists;
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
import org.testng.annotations.Test;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

public class Login {



    @Test(priority = 1)
    public void openURL() throws URISyntaxException, IOException {

        String url = Constant.url;

//            建立一个新的请求客户端
        CloseableHttpClient httpClient = HttpClients.createDefault();

        HttpClientContext httpClientContext = HttpClientContext.create();


        HttpUriRequest  httpUriRequest = RequestBuilder.get().setUri(new URIBuilder(url).build()).build();


//        使用HttpGet方式请求网址
//        HttpGet httpGet = new HttpGet(Constant.url);

//      获取网址的返回结果
        CloseableHttpResponse response = null;

        {
            try {
//                response = httpClient.execute(httpGet);
                response = httpClient.execute(httpUriRequest,httpClientContext);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        CookieStore cookies = httpClientContext.getCookieStore();
        this.saveCookieStore(cookies,"cookie");

//        获取返回结果中的实体
        HttpEntity entity = response.getEntity();

//        将返回的实体输出
        try {
            System.out.println(EntityUtils.toString(entity));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test(priority = 2)
    public void loginURL() throws URISyntaxException, IOException, ClassNotFoundException {

        CookieStore cookieStore = this.readCookieStore("cookie");

//        构造路径参数

        List<NameValuePair> nameValuePairList1 = Lists.newArrayList();
        nameValuePairList1.add(new BasicNameValuePair("method","securityCodeImage"));
        nameValuePairList1.add(new BasicNameValuePair("seed","0.5791360342631169"));
        this.get(Constant.url+"/loginAction.action", nameValuePairList1,cookieStore);

//        构造路径参数
        List<NameValuePair> nameValuePairList = Lists.newArrayList();
        nameValuePairList.add(new BasicNameValuePair("loginId",Constant.loginUsername));
        nameValuePairList.add(new BasicNameValuePair("password",Constant.loginPassword));
        nameValuePairList.add(new BasicNameValuePair("validateCode","1234"));
        this.post(Constant.url+"/loginAction.action?method=login",nameValuePairList,cookieStore);

    }

    /**
     * 医院违规病例反馈
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws URISyntaxException
     */
    @Test(priority = 3)
    public void illegalMedicalAll() throws IOException, ClassNotFoundException, URISyntaxException {
        CookieStore cookieStore = this.readCookieStore("cookie");
        List<NameValuePair> nameValuePairList = Lists.newArrayList();
        nameValuePairList.add(new BasicNameValuePair("illegalClass","1"));
        nameValuePairList.add(new BasicNameValuePair("diseaseName",""));
        nameValuePairList.add(new BasicNameValuePair("diseaseId",""));
        nameValuePairList.add(new BasicNameValuePair("startCreateTime","2013-10-09"));
        nameValuePairList.add(new BasicNameValuePair("endCreateTime","2022-03-16"));
        nameValuePairList.add(new BasicNameValuePair("diseaseId",""));
        nameValuePairList.add(new BasicNameValuePair("undefined",""));
        nameValuePairList.add(new BasicNameValuePair("pageRecords","200"));
        this.post(Constant.url+"/app/illegalMedical/illegalMedicalAllotAction.action?method=queryAllIllegalInfoForHospital",nameValuePairList,cookieStore);

    }


    /**
     * GET请求
     * @param url
     * @param nameValuePairList
     * @param cookieStore
     * @throws URISyntaxException
     * @throws IOException
     */
    public void get(String url,List<NameValuePair> nameValuePairList,CookieStore cookieStore) throws URISyntaxException, IOException {

//      构造请求资源地址
        URI uri;

        if(nameValuePairList!=null){
            //      构造请求路径，并添加参数
            uri = new URIBuilder(url).addParameters(nameValuePairList ).build();
        }else{
            uri = new URIBuilder(url).build();
        }

//      构造Headers
        List<Header> headerList = Lists.newArrayList();
        headerList.add(new BasicHeader(HttpHeaders.ACCEPT_ENCODING,"gzip,deflate"));
        headerList.add(new BasicHeader(HttpHeaders.CONNECTION,"keep-alive"));
        HttpClientBuilder httpClientBuilder = HttpClients.custom();

//        设置代理IP、端口、协议（请分别替换）
//        HttpHost proxy = new HttpHost("127.0.0.1",8888,"http");
//        把代理设置到请求配置
//        RequestConfig requestConfig = RequestConfig.custom().setProxy(proxy).build();
//        httpClientBuilder.setDefaultRequestConfig(requestConfig);

        httpClientBuilder.setDefaultHeaders(headerList);
        if(cookieStore!=null){
            httpClientBuilder.setDefaultCookieStore(cookieStore);
        }


        HttpClient httpClient = httpClientBuilder.build();
        HttpUriRequest  httpUriRequest = RequestBuilder.get().setUri(uri).build();

        HttpResponse httpResponse = httpClient.execute(httpUriRequest);


        HttpEntity entity = httpResponse.getEntity();

        System.out.println(EntityUtils.toString(entity));

    }


    /**
     * POST表单形式提交参数
     * @param url
     * @param nameValuePairList
     * @param cookieStore
     * @throws URISyntaxException
     * @throws IOException
     */
    public void post(String url,List<NameValuePair> nameValuePairList,CookieStore cookieStore) throws URISyntaxException, IOException {


        HttpClientBuilder httpClientBuilder = HttpClients.custom();

        //      构造Headers
        List<Header> headerList = Lists.newArrayList();
        headerList.add(new BasicHeader(HttpHeaders.CONNECTION,"keep-alive"));
        headerList.add(new BasicHeader(HttpHeaders.ACCEPT_LANGUAGE,"zh-CN,zh;q=0.9"));
        headerList.add(new BasicHeader(HttpHeaders.ACCEPT_ENCODING,"gzip,deflate"));
        httpClientBuilder.setDefaultHeaders(headerList);


        /*
//        把代理设置到请求配置
        HttpHost proxy = new HttpHost("127.0.0.1",8888,"http");
        RequestConfig requestConfig = RequestConfig.custom().setProxy(proxy).build();
        httpClientBuilder.setDefaultRequestConfig(requestConfig);*/


        if(cookieStore!=null){
            httpClientBuilder.setDefaultCookieStore(cookieStore);

        }

        HttpClient httpClient = httpClientBuilder.build();
        HttpPost httpPost = new HttpPost(url);
        httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairList));
        HttpResponse httpResponse = httpClient.execute(httpPost);
        HttpEntity entity = httpResponse.getEntity();

        System.out.println(EntityUtils.toString(entity));


    }


    /**
     * 保存cookies
     * @param cookie
     * @param savePath
     * @throws IOException
     */
    public void saveCookieStore(CookieStore cookie,String savePath) throws IOException {
        FileOutputStream fos = new FileOutputStream(savePath);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(cookie);
        oos.close();
    }


    /**
     *读取cookies
     * @param savePath
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public CookieStore readCookieStore(String savePath) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("cookie");
        ObjectInputStream ois = new ObjectInputStream(fis);
        CookieStore cookieStore = (CookieStore) ois.readObject();
        ois.close();
        return cookieStore;
    }


}
