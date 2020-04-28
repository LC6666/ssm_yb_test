package com.iebm.api.test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.testng.Assert;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.iebm.api.beans.BaseBean;
import com.iebm.ssm.util.AssertUtil;
import com.iebm.ssm.util.ExcelUtil;
import com.iebm.ssm.util.FunctionUtil;
import com.iebm.ssm.util.StringUtil;


/**
 * @author LC
 *
 */
public class TestBase {
	
	/**
	 * 公共参数数据池（全局可用）
	 */
	private static Map<String,String> saveDatas = new HashMap<String,String>();
	
	
	/**
	 * 替换符，如果数据中包含“${}”则会被替换成公共参数中存储的数据
	 */
	protected Pattern replaceParamPattern = Pattern.compile("\\$\\{(.*?)\\}");
	
	
	/**
	 * 截取自定义方法正则表达式：_xxx(ooo)
	 */
	protected Pattern funPattern = Pattern.compile("__(\\w*?)\\((([\\w\\\\\\/:\\.\\$]*,?)*)\\)");
	
	protected void setSaveDatas(Map<String,String> map){
		saveDatas.putAll(map);
	}
	
	protected String getSaveDatas(String key){
		if("".equals(key)||!saveDatas.containsKey(key)){
			return null;
		}else{
			return saveDatas.get(key);
		}
	}
	
	
	/**
	 * 组件预参数（处理_fun()以及${xxxx}）
	 * @param preParam
	 * @return
	 */
	protected String buildParam(String param) {
		// TODO Auto-generated method stub
		param = getCommonParam(param);
		Matcher m = funPattern.matcher(param);
		while(m.find()) {
			String funcName = m.group(1);
			String args = m.group(2);
			String value;
//			bodyfile属于特殊情况，不进行匹配，在post请求的时候进行处理
			if(FunctionUtil.isFunction(funcName)&& !funcName.equals("bodyfile")) {
//				属于函数助手，调用哪个函数助手获取
				value = FunctionUtil.getValue(funcName, args.split(","));
//				解析对应的函数失败
				param = StringUtil.replaceFirst(param, m.group(), value);				
			}
		}
		return param;
	}
	
	
	/**
	 * 通过“;”分隔，将参数加入公共参数map中
	 * @param preParam
	 */
	protected void savePreParam(String preParam) {
		// TODO Auto-generated method stub
//		通过“;”分隔，将参数加入公共参数map中
		if(StringUtil.isEmpty(preParam)) {
			return;
		}
		String[] preParamArr = preParam.split(";");
		String key,value;
		for(String prepar:preParamArr) {
			if(StringUtil.isEmpty(prepar)) {
				continue;
			}
			key = prepar.split("=")[0];
			value = prepar.split("=")[1];
			saveDatas.put(key,value);
		}
		
	}
	

	/**
	 * 取公共参数 并替换参数
	 * @param param
	 * @return
	 */
	protected String getCommonParam(String param) {
		// TODO Auto-generated method stub
		if(StringUtil.isEmpty(param)){
			return "";
		}
		Matcher m = replaceParamPattern.matcher(param);
		while(m.find()){
			String replaceKey = m.group(1);
			String value;
//			从公共参数池中获取值
			value = getSaveData(replaceKey);
			param = param.replace(m.group(), value);
		}
		System.out.println("TestBase getCommonParam() param="+param);
		return param;
	}

	/**
	 * 获取公共数据池中的数据
	 * @param replaceKey  公共数据的key
	 * @return 对应的value
	 */
	protected String getSaveData(String replaceKey) {
		// TODO Auto-generated method stub
		if("".equals(replaceKey)|| !saveDatas.containsKey(replaceKey)){
			return null;
		}else{
			return saveDatas.get(replaceKey);
		}
		
	}

	/**
	 * 根据配置读取测试用例
	 * @param clz 需要转换的类
	 * @param excelPathArr 所有excel的路径配置
	 * @param excelName 本次需要过滤的excel文件名 
	 * @param sheetNameArr 本次需要过滤的sheet名
	 * @return 返回数据
	 * @throws DocumentException
	 */
	protected <T extends BaseBean> List<T> readExcelData(Class<T> clz,String[] excelPathArr,String[] sheetNameArr){
		
//		excel文件数组
		List<T> allExcelData = new ArrayList<T>();
		List<T> temArrayList = new ArrayList<T>();
//		System.out.println(clz);
		for(String excelPath:excelPathArr){
//			System.out.println(excelPath);
			File file = Paths.get(System.getProperty("user.dir"),excelPath).toFile();
			temArrayList.clear();
			if(sheetNameArr.length == 0 || sheetNameArr[0] == ""){
				temArrayList = ExcelUtil.readExcel(clz, file.getAbsolutePath());
			}else{
				for(String sheetName : sheetNameArr){
//					System.out.println(sheetName);
					temArrayList.addAll(ExcelUtil.readExcel(clz, file.getAbsolutePath(),sheetName));
				}
			}
			temArrayList.forEach((bean)->{
				bean.setExcelName(file.getName());
			});
//			将excel数据添加至list
			allExcelData.addAll(temArrayList);
		}
		
		return allExcelData;
		
	}
	
	
	protected void verifyResult(String responseData, String verify, boolean contains) throws IOException {
		// TODO Auto-generated method stub
		if(StringUtil.isEmpty(verify)) {
			return;
		}
		String allVerify = getCommonParam(verify);
		if(contains) {
//			验证结果包含
			AssertUtil.contains(responseData,allVerify);
		}else {
//			通过“;”分隔，通过jsonPath进行一一校验
			Pattern pattern = Pattern.compile("([^;]*)=([^;]*)");
			Matcher m = pattern.matcher(allVerify.trim());
			while(m.find()) {
				String actualValue = getBuildValue(responseData,m.group(1));
				String exceptValue = getBuildValue(responseData, m.group(2));
				Assert.assertEquals(actualValue, exceptValue,"验证预期结果失败");
			}
		}
	}

	
	
	/**
	 * 获取格式化后的值
	 * @param sourceJson
	 * @param key
	 * @return
	 * @throws IOException 
	 */
	private String getBuildValue(String sourceJson, String key) throws IOException {
		// TODO Auto-generated method stub
		key = key.trim();
		Matcher funMatch = funPattern.matcher(key);
//		jsonpath
		if(key.startsWith("$.")) {
			try {
				key = new ObjectMapper().readTree(sourceJson).get(key).asText();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		}else if(funMatch.find()) {
			String args = funMatch.group(2);
			String[] argArr = args.split(",");
			for(int index=0;index<argArr.length;index++) {
				String arg = argArr[index];
				if(arg.startsWith("$.")) {
					argArr[index] = new ObjectMapper().readTree(sourceJson).get(arg).asText();
				}
			}
			String value = FunctionUtil.getValue(funMatch.group(1), argArr);
			key = StringUtil.replaceFirst(key, funMatch.group(), value);
		}
		return key;
	}
	
	
	
	/**
	 * 提取json串中的值保存至公共池中
	 * @param json 将被提取的json串。
	 * @param save 所有将被保存的数据：xx=$.jsonpath.xx;oo=$.jsonpath.oo，将$.jsonpath.
	 *            xx提取出来的值存放至公共池的xx中，将$.jsonpath.oo提取出来的值存放至公共池的oo中
	 * @throws IOException 
	 */
	protected void saveResult(String json, String allSave) throws IOException {
		// TODO Auto-generated method stub
		if(null == json ||"".equals(json)||null == allSave ||"".equals(allSave)) {
			return;
		}
		
		allSave = getCommonParam(allSave);
		String[] saves = allSave.split(";");
		String key,value;
		for(String save:saves) {
			Pattern pattern = Pattern.compile("([^;=]*)=([^;]*)");
			Matcher m = pattern.matcher(save.trim());
			while(m.find()) {
				key = getBuildValue(json, m.group(1));
				value = getBuildValue(json, m.group(2));
				saveDatas.put(key, value);
			}
		}
		
		
	}

	
}
