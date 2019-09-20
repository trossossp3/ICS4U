package com.bayviewglen.nQueens;

public class Stack {
	
	Queen[] q;
	int numQueens;
	
	public Stack(int n) {
		numQueens =0;
		q = new Queen[n];
	}
/**
 * returns the number of queens
 * @return number of queens
 */
	public int numQueens() {
		return numQueens;
	}
	/**
	 * Returns the queen on top of the stack
	 * 
	 * @return the queen on top of the stack
	 */
	public Queen peek() {

		if(numQueens <=0) {
			return null;
		}else {
			return q[numQueens-1];
		}
	

	}

	/**
	 * removes top queen
	 * 
	 * @return if the queens been popped
	 */
	public Queen pop() {
		Queen q1 = q[numQueens-1];
		q[numQueens-1] = null;
		numQueens--;
		return q1;
	}

	/**
	 * add queen to stack
	 * 
	 * @param x the queen to add
	 */
	public void push(Queen x) {
		q[numQueens++] = x;

	}

}
