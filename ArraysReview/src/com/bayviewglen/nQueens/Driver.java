package com.bayviewglen.nQueens;
/**
 * Driver class for N-Queens
 * @author Trent Rossos
 *
 */
public class Driver {
	public static void main(String[] args) {
		int n = 10;
		
		Board b = new Board(n);
		b.doIt();
	}

}
