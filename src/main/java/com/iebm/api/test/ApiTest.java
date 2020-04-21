package com.iebm.api.test;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.http.Header;
import org.apache.http.client.HttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.params.CoreConnectionPNames;
import org.testng.ITestContext;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.iebm.api.beans.ApiDataBean;
import com.iebm.api.config.ApiConfig;
import com.iebm.ssm.util.Log;
import com.iebm.ssm.util.SSLClient;


public class ApiTest extends TestBase{
	
	private static HttpClient sslclient;
	
	/*
	 * 是否使用form-data传参 会在post与put方法封装请求参数中用到
	 * */
	private static boolean requestByFormData = false;
	
	/*
	 * 配置文件
	 * */
	private static ApiConfig apiconfig;
	
	/**
	 * 所有公共header，会在发送请求的时候添加到http header上
	 */
	private static Header[] publicHeaders;
	
	protected List<ApiDataBean> dataList;
	
	
	
	
	
	@Parameters("envName")
	@BeforeSuite
	public void init(@Optional("api-config.xml")String envName) throws Exception{
		Log.info("@BeforeSuite");
		String configFilePath = Paths.get(System.getProperty("user.dir"), envName).toString();
//		System.out.println("user.dir="+configFilePath);
		Log.info("api config path:"+configFilePath);
//		读取apiconfig，获取相应信息
		apiconfig = new ApiConfig(configFilePath);
		Log.info(apiconfig.getRootUrl());
		Log.info(apiconfig.getHeaders().toString());
//		读取apiconfig中的param参数，保存到公共数据map
		Map<String,String> params = apiconfig.getParams();
		setSaveDatas(params);
		
//		读取apiconfi中的headers参数，保存转入http请求headers
		List<Header> headers = new ArrayList<Header>();
		apiconfig.getHeaders().forEach((key,value)->{
			Header header = new BasicHeader(key, value);
			if(!requestByFormData&&key.equalsIgnoreCase("content-type")&&value.toLowerCase().contains("form-data")){
				requestByFormData = true;
			}
			headers.add(header);
		});
		
		publicHeaders = headers.toArray(new Header[headers.size()]);
		
		sslclient = new SSLClient();
		// 请求超时
		sslclient.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 60000);
		// 读取超时
		sslclient.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, 60000);
		
		
		
	}
	
	
	
	@Parameters({"excelPath","sheetName"})
	@BeforeTest
	public void readData(@Optional("case/api_test.xlsx")String excelPath,@Optional("Sheet1")String sheetName){
		Log.info("@BeforeTest");
		dataList = readExcelData(ApiDataBean.class,excelPath.split(";"),sheetName.split(";"));
	}
	
	
	
	
	/**
	 * 过滤数据，run标记为Y的执行
	 * @param context
	 * @return
	 */
	@DataProvider(name="apiDatas")
	public Iterator<Object[]> getApiData(ITestContext context){
		Log.info("@DataProvider");
		List<Object[]> dataProvider = new ArrayList<Object[]>();
		for(ApiDataBean data:dataList){
			if(data.isRun()){
				dataProvider.add(new Object[]{data});
			}
			
		}
		System.out.println(dataProvider.size());
		return dataProvider.iterator();
		
	}
	
	
	
	@Test(dataProvider = "apiDatas")
	public void apiTest(){
		Log.info("@Test");
	}
}
