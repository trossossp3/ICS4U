package com.bayviewglen.quickSort;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class RandomNums {
	
	public static int[] arr;

	private static void random(int n1, int n2, int n3) throws IOException {
		int[] arr = new int[n3];
		for (int i = 0; i < n3; i++) {
			if (n1 == 0)
				arr[i] = ((int) (Math.random() * (n2 + 1)));
			else {
				arr[i] = ((int) (Math.random() * ((n2 - n1) + 1) + n1));
			}

		}
		print(arr, n3);
	}

	private static void print(int[] arr, int amountNums) throws IOException {

		
		BufferedWriter out = new BufferedWriter(new FileWriter("C:\\Dev\\ICS4U\\Algorithms\\src\\com\\bayviewglen\\quickSort\\test.txt"));
		System.out.println("unsorted list");
		out.write(amountNums+"\n");
		for (int i = 0; i < arr.length; i++) {
			
			String s1 = arr[i]+"\n";
			System.out.print(arr[i]+" ");
			out.write(s1);
			
		}
		System.out.println();
		out.close();
	}
	/**
	 * 
	 * @param a is lowerbound
	 * @param b upperbound
	 * @param c amount of nums
	 * @throws IOException 
	 */
	public void doIt(int a,int b, int c) throws IOException{

		int lowerBound = a;
		int upperBound = b;
		int amountNums = c;

		random(lowerBound, upperBound, amountNums);
	}

}
