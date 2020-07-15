package assignment2018;

import assignment2018.codeprovided.*;
import assignment2018.codeprovided.Piece;
import assignment2018.codeprovided.PieceCode;

import java.util.*;

import assignment2018.Move;

/**
 * Bishop.java
 * 
 * Class for the bishop piece
 * 
 *
 */

public class Bishop extends Piece {
	// constructor
	public Bishop(int ix, int iy, int c, Board b) {
		super(PieceCode.BISHOP, ix, iy, c, b);
	}

	// method implements abstract availableMoves method in Piece class
	public ArrayList<Move> availableMoves() {
		if (getColour() == PieceCode.WHITE)
			return whiteBishop();
		else
			return blackBishop();
	}

	// method to return list of legal moves for a white Bishop
	private ArrayList<Move> whiteBishop() {
		// obtain current co-ordinates
		int x = this.getX();
		int y = this.getY();

		// otherwise create a new vector to store legal whiteMoves
		ArrayList<Move> whiteMoves = new ArrayList<Move>();

		// set up m to refer to a Move object
		Move theMove = null;

		// available moves

		for (int i = 0; i <= 7; i++)
			for (int j = 0; j <= 7; j++) {
				if (Math.abs(i - x) == Math.abs(j - y)) {
					if (clearPath(x, y, i, j)) {

						theMove = new Move(this, x, y, i, j, false);
						whiteMoves.add(theMove);

					}
				}
			}
		return whiteMoves;
	}

	// method to return list of legal moves for a black Bishop
	private ArrayList<Move> blackBishop() {
		// obtain current co-ordinates
		int x = this.getX();
		int y = this.getY();

		// create a new vector to store legal blackMoves
		ArrayList<Move> blackMoves = new ArrayList<Move>();

		// set up m to refer to a Move object
		Move theMove = null;

		// available moves
		for (int i = 0; i <= 7; i++)
			for (int j = 0; j <= 7; j++) {
				if (Math.abs(i - x) == Math.abs(j - y)) {
					if (clearPath(x, y, i, j)) {

						theMove = new Move(this, x, y, i, j, false);
						blackMoves.add(theMove);

					}
				}
			}
		return blackMoves;
	}

	// method for making sure there are no obstacles in the way
	public boolean clearPath(int or, int oc, int nr, int nc) {
		Board b = this.getBoard();

		if (or == nr || oc == nc) {
			// Did not move diagonally
			return false;
		}

		if (Math.abs(nr - or) != Math.abs(nc - oc)) {
			return false;
		}

		int rowOffset, colOffset;

		if (or < nr) {
			rowOffset = 1;
		} else {
			rowOffset = -1;
		}

		if (oc < nc) {
			colOffset = 1;
		} else {
			colOffset = -1;
		}

		int y = oc + colOffset;
		for (int x = or + rowOffset; x != nr; x += rowOffset) {

			if (b.getPiece(x, y) != null) {
				return false;
			}

			y += colOffset;
		}

		return true;

	}

}