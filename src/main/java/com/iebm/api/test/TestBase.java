package com.iebm.api.test;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.iebm.api.beans.BaseBean;
import com.iebm.ssm.util.ExcelUtil;

public class TestBase {
	
	/**
	 * 公共参数数据池（全局可用）
	 */
	private static Map<String,String> saveDatas = new HashMap<String,String>();
	
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
		System.out.println(clz);
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
	
}
