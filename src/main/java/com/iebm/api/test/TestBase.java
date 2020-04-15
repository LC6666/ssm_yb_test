package com.iebm.api.test;

import java.util.HashMap;
import java.util.Map;

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
	
}
