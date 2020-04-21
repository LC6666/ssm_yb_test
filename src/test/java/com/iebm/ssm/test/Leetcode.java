package com.iebm.ssm.test;

public class Leetcode {
	 
	
	public static int[] twoSum(int[] nums,int target){
		int[] reval = new int[2];
		for(int i=0;i<nums.length-1;i++){
			for(int j=i+1;j<nums.length;j++){
				if(nums[i]+nums[j]==target){
					reval[0]=i;
					reval[1]=j;
					return reval;
				}
			}
		}
		return null;
	}
	
	

	public static void main(String[] args) {
		int[] reval = Leetcode.twoSum(new int[] {1, 15, 3, 5}, 9);
		System.out.println(reval[0]+"==="+reval[1]);
	}
}
