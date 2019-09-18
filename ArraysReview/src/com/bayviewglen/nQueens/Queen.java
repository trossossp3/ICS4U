package com.bayviewglen.nQueens;
/**
 * Queen class for 
 * @author Trent Rossos
 *
 */
public class Queen {
	private int row;
	private int col;
	
	public Queen(int r, int c) {
		row = r;
		col = c;
	}
	/**
	 * return the queens row
	 * @return the queen's row
	 */
	public int getRow() {
		return row;
	}
	/**
	 * return the queens column
	 * @return the queen's column
	 */
	public int getCol() {
		return col;
	}

}
