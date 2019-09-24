package com.bayviewglen.postfix;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class postfixing {
	Stack stack = new Stack();
	String file = "C:\\Dev\\ICS4U\\ArraysReview\\src\\com\\bayviewglen\\postfix\\data.txt";
	public void doIt() throws IOException {
		BufferedReader in = new BufferedReader(new FileReader(file));
		String[] chars = in.readLine().split(" ");
		
		for(int i=0;i<chars.length;i++) {
			process(chars[i]);			
		}
		System.out.println(stack.toString());
	}
	

	public void process(String s1) {
		if(s1.equals("+")) {
			addition();
		}else if(s1.equals("-")) {
			subtraction();
		}else if(s1.equals("*")) {
			multiply();
		}else if(s1.equals("/")) {
			division();
		}else {
			number(s1);
		}
	}


	private void number(String s1) {
		stack.push(s1);
		
	}


	private void division() {
		int n2 = Integer.parseInt(stack.pop());
		int n1 = Integer.parseInt(stack.pop());
		stack.push(Integer.toString(n1/n2));
		
	}


	private void multiply() {
		int n2 = Integer.parseInt(stack.pop());
		int n1 = Integer.parseInt(stack.pop());
		stack.push(Integer.toString(n1*n2));
		
	}


	private void subtraction() {
		int n2 = Integer.parseInt(stack.pop());
		int n1 = Integer.parseInt(stack.pop());
		stack.push(Integer.toString(n1-n2));
		
	}


	private void addition() {
		int n2 = Integer.parseInt(stack.pop());
		int n1 = Integer.parseInt(stack.pop());
		stack.push(Integer.toString(n1+n2));
		
	}
}
