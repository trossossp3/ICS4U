package com.bayviewglen.nQueens;

/**
 * This is the Board class of the N-Queens problem. This class contains all of
 * the algorithm implementation, as well as the array stack methods
 * 
 * @author Trent Rossos
 *
 */

public class Board {
	private Queen[] queens;
	private int numQueens;
	private int n;

	/**
	 * 
	 * @param n the int that dictates the dimensions of the board
	 */
	public Board(int n) {
		this.n = n;
		numQueens = 0;
		queens = new Queen[n];
	}

	/**
	 * This is the driving method that will complete the n queens problem
	 */
	public void doIt() {
		while (numQueens > -1 && numQueens < n) {
			if (!place()) {
				if (!pop()) {
					break;

				}

			}
		}
		if (numQueens > 0) {
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
		for (int i = 0; i < numQueens; i++) {
			if (queens[i].getRow() == row && queens[i].getCol() == col) {
				return true;
			}
		}
		return false;
	}

	/**
	 * This method places a queen on the board
	 * 
	 * @return a boolean true if places false otherwise
	 */
	public boolean place() {
		Queen cur;
		try {
			cur = new Queen(peek().getRow() + 1, numQueens); // place a queen one row above last queen placed

		} catch (Exception ex) {
			cur = new Queen(0, numQueens); // if there is no queens placed place one in the first row
		}
		boolean placed = false;
		while (!placed && cur.getRow() < n) {
			if (canPlace(cur)) {
				push(cur);
				return true;
			}
			cur = new Queen(cur.getRow() + 1, numQueens);
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
		if (numQueens == 0) {
			return true;
		}
		for (int i = 0; i < numQueens; i++) {
			if (queens[i].getRow() == cur.getRow()) { // if there is a queen in same row return false
				return false;
			} else if (canDiagonal(cur, queens[i])) {
				return false;
			}
		}
		return true;
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

	/**
	 * Returns the queen on top of the stack
	 * 
	 * @return the queen on top of the stack
	 */
	public Queen peek() {

		if (queens[0] == null) {
			throw new IllegalStateException("zoinks");
		} else if (numQueens == 0) {
			return queens[0];
		}
		return queens[numQueens];

	}

	/**
	 * removes top queen
	 * 
	 * @return if the queens been popped
	 */
	public boolean pop() {
		queens[numQueens] = null;
		numQueens--;
		if (numQueens < 0) {
			return false;
		}
		return true;
	}

	/**
	 * add queen to stack
	 * 
	 * @param x the queen to add
	 */
	public void push(Queen x) {
		queens[numQueens++] = x;

	}

}
