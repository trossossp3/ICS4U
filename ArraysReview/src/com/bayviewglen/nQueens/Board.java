package com.bayviewglen.nQueens;

/**
 * This is the Board class of the N-Queens problem. This class contains all of
 * the algorithm implementation, as well as the array stack methods
 * 
 * @author Trent Rossos
 *
 */

public class Board {
	private Stack queens;
	
	private int n;

	/**
	 * 
	 * @param n the int that dictates the dimensions of the board
	 */
	public Board(int n) {
		this.n = n;

		queens = new Stack(n);
	}

	/**
	 * This is the driving method that will complete the n queens problem
	 */
	public void doIt() {
		while (queens.numQueens() > -1 && queens.numQueens() < n) {
			if (!place()) {
				try {
					while (!replace())
						queens.pop();

				} catch (Exception ex) {
					break;
				}

			}

		}
		if (queens.numQueens() > 0)

		{
			printBoard();
		} else {
			System.out.println("No solutions at n = " + n);
		}
	}

	/**
	 * This method prints the chess board with "Q" as queens and "x" and blank
	 * spaces
	 */
	private void printBoard() {
		for (int row = 0; row < n; row++) {
			for (int col = 0; col < n; col++) {
				if (checkPosition(row, col))
					System.out.print(" Q ");
				else
					System.out.print(" x ");

			}
			System.out.println();

		}
	}

	/**
	 * This method checks if there is a queen at location (row,col)
	 * 
	 * @param row the current row of the chess board it is checking
	 * @param col the current column being checked
	 * @return true if there is a queen at (row,col) and false otherwise
	 */
	private boolean checkPosition(int row, int col) {
		Stack temp = new Stack(n);
		boolean flag = false;
		while (queens.numQueens() > 0) {
			temp.push(queens.pop());

			if (temp.peek().getRow() == row && temp.peek().getCol() == col) {
				flag = true;;
				break;

			}
		}
		while(temp.numQueens()>0) {
			queens.push(temp.pop());
		}
		return flag;
	}

	/**
	 * This method places a queen on the board
	 * 
	 * @return a boolean true if places false otherwise
	 */
	public boolean place() {
		Queen cur = new Queen(0, queens.numQueens());

		boolean placed = false;
		while (!placed && cur.getRow() < n) {
			if (canPlace(cur)) {
				queens.push(cur);
				return true;
			}
			cur = new Queen(cur.getRow() + 1, queens.numQueens());
		}
		return false;
	}
	/**
	 * replaces queen with queen beside it
	 * @return true if queen can be replaced
	 */
	private boolean replace() {
		Queen cur = new Queen(queens.peek().getRow() + 1, queens.pop().getCol());

		boolean placed = false;
		while (!placed && cur.getRow() < n) {
			if (canPlace(cur)) {
				queens.push(cur);
				return true;
			}
			cur = new Queen(cur.getRow() + 1, queens.numQueens());
		}
		return false;
	}

	/**
	 * This method determines if the queen can be placed without being attacked by
	 * another queen
	 * 
	 * @param cur the current the queen that is being placed
	 * @return true if cur can be placed false otherwise
	 */
	private boolean canPlace(Queen cur) {
		if (queens.numQueens() == 0) {
			return true;
		}
		boolean flag = true;
		Stack temp = new Stack(n);
		while(queens.numQueens()>0) {
			temp.push(queens.pop());
			if (temp.peek().getRow() == cur.getRow()) { // if there is a queen in same row return false
				flag= false;
			} else if(temp.peek().getCol()==cur.getCol()) {
				flag = false;
			}
			else if (canDiagonal(cur, temp.peek())) {
				flag = false;
			}
		}
		while(temp.numQueens()>0) {
			queens.push(temp.pop());
		}
		return flag;

	}

	/**
	 * This method determines the queens safety on the diagonal axis
	 * 
	 * @param cur    the current queen being placed on the board
	 * @param placed a queen that has already been placed
	 * @return if the queen if safe on the diagonal axis
	 */
	private boolean canDiagonal(Queen cur, Queen placed) {
		for (int i = 0; i < n && i > -1; i++) {
			if ((placed.getCol() + i == cur.getCol() && placed.getRow() + i == cur.getRow())) { // check if it is down
																								// left
				return true;
			} else if (placed.getCol() + i == cur.getCol() && placed.getRow() - i == cur.getRow()) { // check if it is
																										// up left
				return true;
			}

		}
		return false;
	}

}
