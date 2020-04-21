package com.iebm.ssm.test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapTest {
	
	private Map<String,String> map = new HashMap<String,String>();
	
	public MapTest(){
		map.put("key0", "value0");
		map.put("key1", "value1");
		map.put("key2", "value2");
		map.put("key3", "value3");
		map.put("key4", "value4");
		map.put("key5", "value5");
		map.put("key6", "value6");
		map.put("key7", "value7");
		map.put("key8", "value8");
		map.put("key9", "value9");
		
	}
	
	public void getMap(){
		System.out.println("通过Map.keySet遍历Key和Value");
		for(String key:map.keySet()){
			System.out.println("key= "+ key + " and value= " + map.get(key));
		}
		
	}
	
	public void iteratorMap(){
		System.out.println("通过Map.enterSet使用iterator遍历key和value");
		Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry<String, String> entry = it.next();
			System.out.println("key= "+ entry.getKey() + " and value= " + entry.getValue());
		}
	}
	
	public static void main(String[] args) {
		MapTest mt = new MapTest();
		mt.getMap();
		mt.iteratorMap();
	}

}
