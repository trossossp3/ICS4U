package com.bayviewglen.quickSort;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Driver {

    // Driver program 
    public static void main(String args[]) throws NumberFormatException, IOException 
    { 
    	
    	RandomNums rn = new RandomNums();
    	rn.doIt(0, 100, 99000);
		BufferedReader br = new BufferedReader(new FileReader("C:\\Dev\\ICS4U\\Algorithms\\src\\com\\bayviewglen\\quickSort\\test.txt"));
		int amountNums = Integer.parseInt(br.readLine());
		int[] arr = new int[amountNums];
		//System.out.println(br.readLine());
		for (int i = 0; i < amountNums; i++) {
			arr[i] = Integer.parseInt(br.readLine());

		}
		br.close();
      
        int n = arr.length; 
  
        QuickSort ob = new QuickSort(); 
        long startTime = System.nanoTime();
        ob.sort(arr, 0, n-1); 
        long endTime = System.nanoTime();
        System.out.println("Took "+(endTime - startTime) + " ns"); 
  
        System.out.println("sorted array"); 
        ob.printArray(arr); 
    } 
} 


