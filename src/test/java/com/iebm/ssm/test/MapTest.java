package com.iebm.ssm.test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapTest {
	
	private static Map<String,String> map = new HashMap<String,String>();
	
	public MapTest(){
		map.put("k0", "v0");
		map.put("k1", "v1");
		map.put("k2", "v2");
		map.put("k3", "v3");
		map.put("k4", "v4");
		map.put("k5", "v5");
		map.put("k6", "v6");
		map.put("k7", "v7");
		map.put("k8", "v8");
		map.put("k9", "v9");
		map.put("k0", "v10");
		getMap();
		iteratorMap();
		entrySetMap();
		getValues();
		
	}
	
	private static void getMap(){
		System.out.println("通过Map.keySet遍历Key和Value");
		for(String key:map.keySet()){
			System.out.println("key= "+ key + " and value= " + map.get(key));
		}
		
	}
	
	private static void iteratorMap(){
		System.out.println("通过Map.enterSet使用iterator遍历key和value");
		Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry<String, String> entry = it.next();
			System.out.println("key= "+ entry.getKey() + " and value= " + entry.getValue());
		}
	}
	
	private static void entrySetMap(){
		System.out.println("通过Map.entrySet遍历key和value");
		for(Map.Entry<String, String> entry:map.entrySet()){
			System.out.println("key= "+ entry.getKey() + " and value= " + entry.getValue());
		}
	}
	
	private static void getValues(){
		System.out.println("通过Map.values()遍历所有的value，但不能遍历key");
		for(String v:map.values()){
			System.out.println("value= " + v);
		}
		
	}
	
	
	public static void main(String[] args) {
		MapTest mt = new MapTest();
	}

}
