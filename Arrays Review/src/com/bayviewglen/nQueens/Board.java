package com.bayviewglen.nQueens;

public class Board {
	private Queen[] queens;
	private int numQueens;
	private int n;

	public Board(int n) {
		this.n = n;
		numQueens = 0;
		queens = new Queen[n];
	}

	public void doIt() {
		while (numQueens > -1 && numQueens < n) {
			if (!place()) {
				if(!pop()) {
					break;
					
				}

			}
		}
		if(numQueens>0) {
			printBoard();
		}else {
			System.out.println("No solutions at n =" + n);
		}
	}

	private void printBoard() {
		for(int row = 0; row<n;row++) {
			for(int col =0;col<n;col++) {
				if(checkPosition(row,col)) {
					System.out.print(" Q ");
				}else {
					System.out.println(" x ");
				}
			System.out.println();
			}
		}
	}

	private boolean checkPosition(int row, int col) {
		for(int i =0;i<numQueens;i++) {
			if(queens[i].getRow() == row && queens[i].getCol()==col) {
				return true;
			}
		}
		return false;
	}

	public boolean place() {
		Queen cur;
		try {
			cur = new Queen(peek().getRow()+1,numQueens); //place  a queen one row above last queen placed
				
			}catch(Exception ex) {
				cur = new Queen(0, numQueens); //if there is no queens placed place one in the first row
			}
		boolean placed= false;
		while(!placed && cur.getRow()<n) {
			if(canPlace(cur)) {
				push(cur);
				return true;
			}
			cur = new Queen(cur.getRow()+1,numQueens);
		}
		return false;
	}

	private boolean canPlace(Queen cur) {
		if(numQueens ==0) {
			return true;		
		}
		for(int i =0;i<numQueens;i++) {
			if(queens[i].getRow() == cur.getRow()) {
				return true;
			}else if(canDiagonal(cur, queens[i])) {
				return true;
			}
		}
		return false;
	}

	private boolean canDiagonal(Queen cur, Queen placed) {
		for(int i=0;i<n;i++) {
			if(placed.getRow()+i==cur.getRow()&&placed.getCol()+i == cur.getCol()) { //check if a queen is up and right of queen trying to be placed
				return false;
			}else if(placed.getRow()-i==cur.getRow()&&placed.getCol()+i == cur.getCol()) { //check if queen is down and right of queen trying to be placed
				return false;
			}
		}
		return true;
	}

	public Queen peek() {

		if (numQueens == 0) {
			throw new IllegalStateException("Bad");
		}
		return queens[numQueens - 1];

	}

	public boolean pop() {
		queens[numQueens] = null;
		numQueens--;
		if (numQueens < 0)
			return false;
		return true;
	}

	public boolean isEmpty() {
		return numQueens == 0;
	}

	public void push(Queen x) {
		queens[numQueens++] = x;
	}
}
