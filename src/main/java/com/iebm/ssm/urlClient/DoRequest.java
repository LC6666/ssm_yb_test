package com.iebm.ssm.urlClient;

import com.google.common.collect.Lists;
import org.apache.http.*;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.List;

public class DoRequest {

    /**
     * GET请求
     * @param url
     * @param nameValuePairList
     * @param cookieStore
     * @throws URISyntaxException
     * @throws IOException
     */
    public static String doget(String url, List<NameValuePair> nameValuePairList, CookieStore cookieStore) throws URISyntaxException, IOException {

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
        /*HttpHost proxy = new HttpHost("127.0.0.1",8888,"http");
//        把代理设置到请求配置
        RequestConfig requestConfig = RequestConfig.custom().setProxy(proxy).build();
        httpClientBuilder.setDefaultRequestConfig(requestConfig);*/

        HttpClientContext httpClientContext = null;
        if(cookieStore!=null){
            httpClientBuilder.setDefaultCookieStore(cookieStore);
        }else{
            httpClientContext = HttpClientContext.create();
        }



        httpClientBuilder.setDefaultHeaders(headerList);


        HttpClient httpClient = httpClientBuilder.build();
        HttpUriRequest httpUriRequest = RequestBuilder.get().setUri(uri).build();

        HttpResponse httpResponse = httpClient.execute(httpUriRequest,httpClientContext);

        if(httpClientContext!=null){
            CookieStore cookies = httpClientContext.getCookieStore();
            MyCookieStore.saveCookieStore(cookies,"cookie");
        }


        HttpEntity entity = httpResponse.getEntity();

        return (EntityUtils.toString(entity));

    }


    /**
     * POST表单形式提交参数
     * @param url
     * @param nameValuePairList
     * @param cookieStore
     * @throws URISyntaxException
     * @throws IOException
     */
    public static String dopost(String url,List<NameValuePair> nameValuePairList,CookieStore cookieStore) throws URISyntaxException, IOException {


        HttpClientBuilder httpClientBuilder = HttpClients.custom();

        //      构造Headers
        List<Header> headerList = Lists.newArrayList();
        headerList.add(new BasicHeader(HttpHeaders.CONNECTION,"keep-alive"));
        headerList.add(new BasicHeader(HttpHeaders.ACCEPT_LANGUAGE,"zh-CN,zh;q=0.9"));
        headerList.add(new BasicHeader(HttpHeaders.ACCEPT_ENCODING,"gzip,deflate"));
        headerList.add(new BasicHeader(HttpHeaders.ACCEPT,"text/plain;charset=utf-8"));
        headerList.add(new BasicHeader(HttpHeaders.CONTENT_TYPE,"application/x-www-form-urlencoded; charset=utf-8"));

        httpClientBuilder.setDefaultHeaders(headerList);



//        把代理设置到请求配置
        /*HttpHost proxy = new HttpHost("127.0.0.1",8888,"http");
        RequestConfig requestConfig = RequestConfig.custom().setProxy(proxy).build();
        httpClientBuilder.setDefaultRequestConfig(requestConfig);*/

        HttpClientContext httpClientContext = null;
        if(cookieStore!=null){
            httpClientBuilder.setDefaultCookieStore(cookieStore);

        }else{
            httpClientContext = HttpClientContext.create();
        }

        HttpClient httpClient = httpClientBuilder.build();
        HttpPost httpPost = new HttpPost(url);

        if(nameValuePairList!=null){

            httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairList,Charset.forName("UTF-8")));
        }

        HttpResponse httpResponse = httpClient.execute(httpPost,httpClientContext);
        if(httpClientContext!=null){
            CookieStore cookies = httpClientContext.getCookieStore();
            MyCookieStore.saveCookieStore(cookies,"cookie");
        }
        HttpEntity entity = httpResponse.getEntity();

        return EntityUtils.toString(entity);


    }
}
