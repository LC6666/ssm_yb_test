package com.iebm.ssm.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.iebm.api.functions.Function;


public class FunctionUtil {
	
	private static final Map<String,Class<? extends Function>> functionsMap = new HashMap<String,Class<? extends Function>>();
	
	static {
//		bodyfile 特殊处理
		functionsMap.put("bodyfile", null);
		List<Class<?>> clazzes = ClassFinder.getAllAssignedClass(Function.class);
		clazzes.forEach((clazz)->{
			try {
				Function tempFunc = (Function)clazz.newInstance();
				String referenceKey = tempFunc.getReferenceKey();
				if(referenceKey.length()>0) {
					functionsMap.put(referenceKey, tempFunc.getClass());
				}
				
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		});
	}

	
	
	public static boolean isFunction(String functionName) {
		// TODO Auto-generated method stub
		return functionsMap.containsKey(functionName);
	}
	
	
	
	public static String getValue(String functionName,String[] args) {
		try {
			return functionsMap.get(functionName).newInstance().execute(args);
		}  catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
	}

}
