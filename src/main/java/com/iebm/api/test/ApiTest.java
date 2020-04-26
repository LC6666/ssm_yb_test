package com.iebm.api.test;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.message.BasicHeader;
import org.apache.http.params.CoreConnectionPNames;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.iebm.api.beans.ApiDataBean;
import com.iebm.api.config.ApiConfig;
import com.iebm.ssm.util.Log;
import com.iebm.ssm.util.RandomUtil;
import com.iebm.ssm.util.SSLClient;


/**
 * @author LC
 * @param 
 *
 */
public class ApiTest extends TestBase{
	
	/**
	 * api请求根路径
	 */
	private static String rootUrl;
	
	/**
	 * 根路径是否以“/”结尾
	 */
	private static boolean rootUrlEndWithSlash = false;
	
	private static HttpClient sslclient;
	
	/**
	 * 是否使用form-data传参 会在post与put方法封装请求参数中用到
	 */
	private static boolean requestByFormData = false;
	
	/** 
	 * 配置文件
	 */
	private static ApiConfig apiconfig;
	
	/**
	 * 所有公共header，会在发送请求的时候添加到http header上
	 */
	private static Header[] publicHeaders;
	
	/**
	 * 所有api测试用例数据
	 */
	protected List<ApiDataBean> dataList;
	
	private static HttpClient client;
	
	
	
	
	
	/**
	 * 初始化测试数据
	 * @param envName
	 * @throws Exception
	 */
	@Parameters("envName")
	@BeforeSuite
	public void init(@Optional("api-config.xml")String envName) throws Exception{
		Log.info("@BeforeSuite");
		String configFilePath = Paths.get(System.getProperty("user.dir"), envName).toString();
//		System.out.println("user.dir="+configFilePath);
		Log.info("api config path:"+configFilePath);
//		读取apiconfig，获取相应信息
		apiconfig = new ApiConfig(configFilePath);
		rootUrl = apiconfig.getRootUrl();
		rootUrlEndWithSlash = rootUrl.endsWith("/");
		
//		Log.info(apiconfig.getRootUrl());
//		Log.info(apiconfig.getHeaders().toString());
		
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
		return dataProvider.iterator();
		
	}
	 
	
	
	/**
	 * @param apiDataBean
	 * @throws InterruptedException
	 * @throws IOException 
	 * @throws ClientProtocolException 
	 */
	@Test(dataProvider = "apiDatas")
	public void apiTest(ApiDataBean apiDataBean) throws InterruptedException, ClientProtocolException, IOException{
		Log.startTestCase("Api Test");
		Log.info(apiDataBean.getDesc());
		if(apiDataBean.getSleep()>0){
			Log.info("sleep "+apiDataBean.getSleep()+" seconds");
			Thread.sleep(apiDataBean.getSleep()*1000);
		}
		
		String apiParam = buildRequestParam(apiDataBean);
		
//		封装请求方法
		HttpUriRequest method = parseHttpRequest(apiDataBean.getUrl(),apiDataBean.getMethod(),apiParam);
		System.out.println("apiTest method="+method);
		
//		String responseData;
		HttpResponse response = client.execute(method);
		int responseStatus = response.getStatusLine().getStatusCode();
		if(apiDataBean.getStatus()!=0){
			Assert.assertEquals(responseStatus, apiDataBean.getStatus(),"返回状态码与预期不符合！");
		}
		
		HttpEntity respEntity = response.getEntity();
		Header respContenType = response.getFirstHeader("Conten-Type");
		if(respContenType !=null && respContenType.getValue()!=null&&(respContenType.getValue().contains("download")||respContenType.getValue().contains("octet-stream"))){
			String conDisposition = response.getFirstHeader("Content-disposition").getValue();
			String fileType = conDisposition.substring(conDisposition.lastIndexOf("."), conDisposition.length());
			String filePath = "download/"+RandomUtil.getRandom(8,false);
		}
		
	}



	/**
	 * 封装请求方法
	 * @param url 请求路径
	 * @param method 请求方法
	 * @param apiParam 请求参数
	 * @return 请求方法
	 * @throws UnsupportedEncodingException 
	 */
	private HttpUriRequest parseHttpRequest(String url, String method, String apiParam) throws UnsupportedEncodingException {
		// TODO Auto-generated method stub
//		处理url
		url = parseUrl(url);
		System.out.println("parseHttpRequest url="+url);
		if("post".equalsIgnoreCase(method)||"uplodad".equalsIgnoreCase(method)){
			//封装post方法
			HttpPost postMethod = new HttpPost(url);
			postMethod.setHeaders(publicHeaders);
			HttpEntity entity = parseEntity(apiParam,requestByFormData);
			postMethod.setEntity(entity);
			return postMethod;
		}else if("put".equalsIgnoreCase(method)){
//			封装Put方法
			HttpPut putMethod = new HttpPut(url);
			putMethod.setHeaders(publicHeaders);
			HttpEntity entity = parseEntity(apiParam, requestByFormData);
			putMethod.setEntity(entity);
			return putMethod;			
			
		}else if("delete".equalsIgnoreCase(method)) {
//			封装delete方法
			HttpDelete deleteMethod = new HttpDelete(url);
			deleteMethod.setHeaders(publicHeaders);
			return deleteMethod;
		}else {
//			封装get方法
			HttpGet getMethod = new HttpGet(url);
			getMethod.setHeaders(publicHeaders);
			return getMethod;
		}
		
	}



	/**
	 * 格式化参数，如果是form-data格式则将参数封装到MultipartEntity否则封装到StringEntity
	 * @param apiParam 参数
	 * @param formData 是否使用form-data格式
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	private HttpEntity parseEntity(String apiParam, boolean formData) throws UnsupportedEncodingException {
		// TODO Auto-generated method stub
		System.out.println("parseEntity apiParam="+apiParam+" formData="+formData);
		if(formData){
			Map<String,String> paramMap = (Map<String, String>) new ObjectMapper().reader();
			MultipartEntity multiEntity = new MultipartEntity();
			
			for(String key:paramMap.keySet()){
				String value = paramMap.get(key);
				Matcher m = funPattern.matcher(value);
				if(m.matches()&&m.group().equals("bodyfile")){
					value = m.group(2);
					multiEntity.addPart(key,new FileBody(new File(value)));
				}else{
					multiEntity.addPart(key,new StringBody(paramMap.get(key)));
				}
			}
			return multiEntity;
			
		}else{
			
		}
		return new StringEntity(apiParam,"UTF-8");
	}



	/**
	 * 格式化url，替换路径参数等
	 * @param url
	 * @return
	 */
	private String parseUrl(String url) {
		// TODO Auto-generated method stub
//		替换url中的参数
		url = getCommonParam(url);
		if(url.startsWith("http")){
			return url;
		}
		if(rootUrlEndWithSlash == url.startsWith("/")){
			if(rootUrlEndWithSlash){
				url = url.replaceFirst("/", "");
			}else{
				url = "/"+url;
			}
		}
		return rootUrl+url;
	}



	/**
	 * 分析处理参数（函数生成的参数）
	 * @param apiDataBean
	 * @return
	 */
	private String buildRequestParam(ApiDataBean apiDataBean) {
		// TODO Auto-generated method stub
		String preParam = buildParam(apiDataBean.getPreParam());
		savePreParam(preParam);
//		处理参数
		String apiParam = buildParam(apiDataBean.getParam());
		return apiParam;
	}



	



	
}
