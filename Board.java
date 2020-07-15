/**
 * Board.java
 * 
 * Class for creating and managing the chess board
 * 
 */
package assignment2018;

import assignment2018.codeprovided.*;

public class Board {
	// 2d array of all the piece objects
	private Piece[][] field = new Piece[8][8];

	public Board() {

	}

	/*
	 * public void initBoard() {
	 * 
	 * Pieces white = new Pieces(this, 1); Pieces black = new Pieces(this, 0); }
	 */

	// returns true if a piece is out of range
	public boolean outOfRange(int x, int i) {
		if (x < 0 || i < 0)
			return true;
		if (x > 7 || i > 7)
			return true;
		else
			return false;
	}

	// method to add/change a piece in the 2d array
	public void setPosition(int i, int j, Piece thePiece) {
		field[i][j] = thePiece;
	}

	// returns true if a position in the 2d array is not null(occupied)
	public boolean occupied(int x, int i) {
		if (x < 0 || i < 0)
			return true;
		if (x >= 8 || i >= 8)
			return true;
		else if (field[x][i] != null)
			return true;
		else
			return false;
	}

	// removes a piece from the 2d array
	public void remove(int i, int j) {
		if (occupied(i, j))
			field[i][j] = null;
	}

	// returns the specified piece
	public Piece getPiece(int x, int y) {

		return field[x][y];

	}

}
