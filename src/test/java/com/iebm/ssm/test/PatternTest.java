package com.iebm.ssm.test;

import java.util.regex.Pattern;

public class PatternTest {
	
	protected static void PatternTest1(){
		Pattern pattern = Pattern.compile("Java");
		//返回此模式的正则表达式即Java
		System.out.println(pattern.pattern());
		
		String test = "123Java456Java789Java";
		String[] result = pattern.split(test);
		for(String s :result){
			System.out.println(s);
		}
		System.out.println("-----------------------------------");
		String[] result2 = pattern.split(test,3);
		for (String s : result2) {
			System.out.println(s);
		}
		
	}
	
	
	public static void main(String[] args) {
		PatternTest.PatternTest1();
	}

}
