package com.iebm.ssm.test;

import java.util.Stack;

/**
 * @author LC
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 *
 */
public class Nowcoder4 {
	
	Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    public void push(int node) {
    	if(stack2.isEmpty()) {
    		stack1.add(node);
    	}else {
    		stack2.add(node);
    	}
    }
    
    public void pop(int node) {
    	if(stack2.isEmpty()) {
    		int size = stack1.size();
    	}
    }

}
