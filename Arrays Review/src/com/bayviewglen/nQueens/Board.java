package com.bayviewglen.nQueens;

public class Board {
	IntArrayStack stack = new IntArrayStack();
	private static int n;
	private static Queen[][] board;

	Board(int n1) {
		n = n1;
		board = new Queen[n][n];
	}
	
	public void solve() {
		for(int row =0; row<n;row++) {
			 for(int col =0; col<n;col++) {
				 boolean b1 = canPlace(row,col);
				 if(b1) {
					 board[row][col] = new Queen();
				 }
			 }
		}
	}

	private boolean canPlace(int row, int col) {
		boolean isSafe = true;
		for(int i =0; i+row<n;i++) {
			if(board[i][col]!=null) {
				isSafe = false;
			}if(board[row][i]!=null) {
				isSafe = false;
			}if(board[row+i][col+i]!=null) {
				isSafe=false;
			}
		}
		return isSafe;
	}

}
