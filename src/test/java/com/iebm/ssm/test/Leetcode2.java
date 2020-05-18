package com.iebm.ssm.test;

import java.util.ArrayList;

/**
 * @author LC
 *	
 */
public class Leetcode2 {
	
	/**
	 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
	 *	请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
	 * @param target
	 * @param array
	 * @return
	 */
	public static boolean find(int target, int [][] array) {		
		int size1 = array.length;
		int size2 = 0;
		int arrayindex , arraylast = 0;
		if(size1>0) {
			for(int i=0;i<size1;i++) {
				size2 = array[i].length;
				if(size2>0) {
					arrayindex = array[i][0];
					arraylast = array[i][size2-1];
					if(arrayindex <= target && target<=arraylast) {
						for(int j = 0;j<size2;j++) {
							if(target == array[i][j]) {
								return true;
							}
						}
					}else {
						continue;
					}
				}				
			}			
		}		
		return false;
    }
	
	
	/**
	 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
	 * @param str
	 * @return
	 */
	public static String replaceSpace(StringBuffer str) {
				
		return str.toString().replace(" ","%20");
	}
	
	
	
	/**
	 * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
	 * @param listNode
	 * @return
	 */
	public class ListNode {
		public int val;
		public ListNode next;
		
		public ListNode(int	val) {
			this.val = val;
		}

	}
	
	private static ArrayList<Integer> list = new ArrayList<Integer>();
	/**
	 * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
	 * @param listNode
	 * @return
	 */
	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		ArrayList<Integer> list2 = this.getArray(listNode);
        int size = list.size(); 
		int temp = 0; 
		int size2 = size/2; 
        
		for(int i=0;i<size2;i++) { 
			temp = list.get(i); 
			System.out.println(i+"--"+(size-1-i));
			list.set(i, list.get(size-1-i));
			list.set(size-1-i, temp); 
		}
		return list2;
	}
	
	public ArrayList<Integer> getArray(ListNode listNode){
		if(listNode!=null) {
            list.add(listNode.val);
			getArray(listNode.next);
		}
		return list;
	}
	
	
		
	
	public static void main(String[] args) {
		Leetcode2 leetcode = new Leetcode2();
//		int [][] array = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
//		boolean f = Leetcode2.find(7, array);
//		System.out.println(f);
		
//		String s = Leetcode2.replaceSpace(new StringBuffer("We Are Happy"));
//		System.out.println(s);
		
//		{92,21,18,47,71,69,67,35,3,22,73}
		ListNode listNode = leetcode.new ListNode(92);
		ListNode listNode2 = leetcode.new ListNode(21);
		
		listNode.next=listNode2;
		ArrayList<Integer> a = leetcode.printListFromTailToHead(listNode);
		int size = a.size();
		for(int i=0;i<size;i++) {
			System.out.print(a.get(i)+"==");
		}
		
	}

}
