/**
 * Rook.java
 */

package assignment2018;

import assignment2018.codeprovided.*;

import java.util.*;

import assignment2018.Move;

public class Rook extends Piece {

	public Rook(int ix, int iy, int c, Board b) {
		super(PieceCode.ROOK, ix, iy, c, b);
	}

	// method implements abstract availableMoves method in Piece class
	public ArrayList<Move> availableMoves() {
		if (getColour() == PieceCode.WHITE)
			return whiteRook();
		else
			return blackRook();
	}

	// method to return list of legal moves for a white Rook
	private ArrayList<Move> whiteRook() {
		// obtain current co-ordinates
		int x = this.getX();
		int y = this.getY();

		// return null if the Rook is at the edge of the board, or if the
		// next move takes it out of range

		// otherwise create a new vector to store legal whiteMoves
		ArrayList<Move> whiteMoves = new ArrayList<Move>();

		// set up m to refer to a Move object
		Move theMove = null;

		for (int i = 0; i <= 7; i++)
			for (int j = 0; j <= 7; j++) {
				if (x == i || y == j) {
					if (clearPath(x, y, i, j)) {
						theMove = new Move(this, x, y, i, j, false);
						whiteMoves.add(theMove);
					}

				}

			}
		return whiteMoves;

	}

	// method to return list of legal moves for a black Rook
	private ArrayList<Move> blackRook() {
		// obtain current co-ordinates
		int x = this.getX();
		int y = this.getY();

		// otherwise create a new vector to store legal whiteMoves
		ArrayList<Move> blackMoves = new ArrayList<Move>();

		// set up m to refer to a Move object
		Move theMove = null;

		for (int i = 0; i <= 7; i++)
			for (int j = 0; j <= 7; j++) {
				if (x == i || y == j) {
					if (clearPath(x, y, i, j)) {
						theMove = new Move(this, x, y, i, j, false);
						blackMoves.add(theMove);
					}

				}

			}
		return blackMoves;

	}

	public boolean clearPath(int cx, int cc, int nr, int nc) {
		Board b = this.getBoard();

		if (cx != nr && cc != nc) {
			return false;
		}

		// rows.
		int offset;

		if (cx != nr) {
			if (cx < nr) {
				offset = 1;
			} else {
				offset = -1;
			}

			for (int x = cx + offset; x != nr; x += offset) {
				if (b.getPiece(x, cc) != null) {
					return false;
				}
			}
		}

		// columns
		if (cc != nc) {
			if (cc < nc) {
				offset = 1;
			} else {
				offset = -1;
			}

			for (int x = cc + offset; x != nc; x += offset) {

				if (b.getPiece(cx, x) != null) {

					return false;
				}
			}
		}

		return true;

	}

}
