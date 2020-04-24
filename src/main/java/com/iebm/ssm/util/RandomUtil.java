package com.iebm.ssm.util;

import java.util.Random;

public class RandomUtil {
	
//	字母和数字
	public static String randomBase = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	public static String randomNumberBase = "0123456789";
	
	
	//Unicode 基本汉字编码范围0x4e00~0x9fa5 共 20902个
	//汉字生成码
	private final static int HANZI_LENGTH=20902;
	
	public static Random random = new Random();
	
	
	
	/**
	 * 随机生成一个汉字
	 * @return
	 */
	protected static char getRandomHanzi(){
		Random ran = new Random();
		return (char)(0x4e00+ran.nextInt(HANZI_LENGTH));
	}
	
	
	/**
	 * 随机生成一个字母或者数字
	 * @return
	 */
	protected static char getRandomStr(){
		Random ran = new Random();
		return (char)randomBase.charAt(ran.nextInt(62));
	}
	
	
	/**
	 * 随机生成一个带有中文的字符串
	 * @param length
	 * @return
	 */
	public static String getRandomText(int length){
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for(int i = 0;i<length;i++){
			int randomNum = random.nextInt(2);
			char ch = 0;
			
			if(randomNum == 0){
//				生成汉字
				ch = getRandomHanzi();
			}else if(randomNum == 1){
				ch = getRandomStr();
			}
			sb.append(String.valueOf(ch));
		}
		return sb.toString();
		
	}
	
	
	public static String getRandom(int length,boolean onlyNumber){
		String base;
		if(onlyNumber){
			base = randomNumberBase;
		}else {
			base = randomBase;
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<length;i++){
			char chr;
			do{
				int number = random.nextInt(base.length());
				chr = base.charAt(number);
			}while(i==0&&chr=='0');
			
			sb.append(chr);
		}
		return sb.toString();		
		
	}
	
	
	public static String getRandomArr(int arryLength,int length,boolean flag){
		StringBuffer sb = new StringBuffer();
		for(int i = 0;i<arryLength;i++){
			sb.append(getRandom(length,flag)).append(",");
		}
		int leng = sb.toString().length();
		return sb.toString().substring(0,leng-1);
	}
	
	
	
	
	/**
	 * 生成定长的字符串数组
	 * @param arrLength
	 * @param paramStr
	 * @return
	 */
	public static String generateStrArr(int arrLength,String paramStr){
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<arrLength;i++){
			sb.append("\"").append(paramStr).append("\"").append(",");
		}
		int leng = sb.toString().length();
		return sb.toString().substring(0,leng-1);
	}
	
	

}
