package com.apple.ist.idms.a3clienttest;

import java.util.*;

public class StackOperations  {

	public static void main(String[] args){
		StackOperations test = new StackOperations();
		//System.out.println( test.isPalindrome(110111));
		String s = "DUP 10 DUP + POP + + -";//"13 DUP 4 POP 5 DUP + DUP + -";
		
		System.out.println( test.solution(s) );
	}
	
	public int solution( String s ) {
		Stack<Integer> stack1 = null;
		int result = 0;
		if( null == stack1) {
			stack1 = new Stack<>();
		}
		
		for(String sliptStr: s.split(" ")){
			System.out.println(stack1);
			
			System.out.println("Operation : "+ sliptStr);
			if(sliptStr.equals("-")){
				int val = minusOperation(stack1);
				if(val == -1 ) {
					result = val;
					break;
				}
			} else if(sliptStr.equals("+")){
				int val = plusOperation(stack1);
				if(val == -1 ) {
					result = val;
					break;
				}
			} else if(sliptStr.equals("DUP")){
				int val = dupOperation(stack1);
				if(val == -1 ) {
					result = val;
					break;
				}
			} else if(sliptStr.equals("POP")){
				popOperation(stack1);
			} else {
				int val = pushOperation(stack1, sliptStr);
				if(val == -1 ) {
					result = val;
					break;
				}
			}
			
			
		}
		
		if(result != -1){
			result = stack1.peek();
		}
		
		return result;
	}
	
	private int pushOperation(Stack<Integer> stack, String str){
		System.out.println("Push "+ str);
		try {
		  stack.push(Integer.valueOf(str));
		} catch(Exception exp){
			return -1;
		}
		return 0;
	}
	
	private int popOperation(Stack<Integer> stack){
		if(stack.size() == 0 ) {
			return -1;
		}
		System.out.println("Pop "+ stack.pop());
		return 0;
	}
	
	private int dupOperation(Stack<Integer> stack){
		if(stack.size() == 0 ) {
			//System.out.println("1.Occured -1 ");
			return -1;
		}
		Integer intVal = (Integer) stack.peek(); 
		System.out.println("Duplicate "+intVal);
		stack.push(intVal);
		return 0;
	}
	
	private int plusOperation(Stack<Integer> stack){
		if(stack.size() <= 1 ) {
			System.out.println("1.Occured -1 ");
			return -1;
		}
		Integer intVal1 = (Integer) stack.pop();
		Integer intVal2 = (Integer) stack.pop();
		System.out.println("Add "+ intVal1 + " and "+ intVal2);
		stack.push( (intVal1+ intVal2) );
		return 0;
	}
	
	private int minusOperation(Stack<Integer> stack){
		if(stack.size() <= 1 ) {
			System.out.println("1.Occured -1 ");
			return -1;
		}
		Integer intVal1 = (Integer) stack.pop();
		Integer intVal2 = (Integer) stack.pop();
		System.out.println("Substact "+ intVal2 + " from "+ intVal1);
		if((intVal1 - intVal2) < 0){
			System.out.println("2.Occured -1 ");
			return -1;
		}
		stack.push( (intVal1 - intVal2) );
		return 0;
	}
}
