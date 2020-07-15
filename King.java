package assignment2018;

import assignment2018.codeprovided.*;
import assignment2018.codeprovided.Piece;
import assignment2018.codeprovided.PieceCode;

import java.util.*;

import assignment2018.Move;

public class King extends Piece {

	public King(int ix, int iy, int c, Board b) {
		super(PieceCode.KING, ix, iy, c, b);
	}

	// method implements abstract availableMoves method in Piece class
	public ArrayList<Move> availableMoves() {
		if (getColour() == PieceCode.WHITE)
			return whiteKing();
		else
			return blackKing();
	}

	// method to return list of legal moves for a white King
	private ArrayList<Move> whiteKing() {
		// obtain current co-ordinates
		int x = this.getX();
		int y = this.getY();

		// create a new vector to store legal whiteMoves
		ArrayList<Move> whiteMoves = new ArrayList<Move>();

		// set up m to refer to a Move object
		Move theMove = null;

		// available moves
		// move up

		theMove = new Move(this, x, y, x, y + 1, false);
		whiteMoves.add(theMove);

		// move down

		theMove = new Move(this, x, y, x, y - 1, false);
		whiteMoves.add(theMove);

		// move right

		theMove = new Move(this, x, y, x + 1, y, false);
		whiteMoves.add(theMove);

		// move left

		theMove = new Move(this, x, y, x - 1, y, false);
		whiteMoves.add(theMove);

		// diagonal movement
		theMove = new Move(this, x, y, x - 1, y - 1, false);
		whiteMoves.add(theMove);

		theMove = new Move(this, x, y, x - 1, y + 1, false);
		whiteMoves.add(theMove);

		theMove = new Move(this, x, y, x + 1, y - 1, false);
		whiteMoves.add(theMove);

		theMove = new Move(this, x, y, x + 1, y + 1, false);
		whiteMoves.add(theMove);

		return whiteMoves;
	}

	// method to return list of legal moves for a black King
	private ArrayList<Move> blackKing() {
		// obtain current co-ordinates
		int x = this.getX();
		int y = this.getY();

		// return null if the King is at the edge of the board, or if the
		// next move takes it out of range

		// otherwise create a new vector to store legal blackMoves
		ArrayList<Move> blackMoves = new ArrayList<Move>();

		// set up m to refer to a Move object
		Move theMove = null;

		// available moves
		// move up
		if (!getBoard().occupied(x, y + 1)) {
			theMove = new Move(this, x, y, x, y + 1, false);
			blackMoves.add(theMove);
		}

		// move down
		if (!getBoard().occupied(x, y - 1)) {
			theMove = new Move(this, x, y, x, y - 1, false);
			blackMoves.add(theMove);
		}

		// move right
		if (!getBoard().occupied(x + 1, y)) {
			theMove = new Move(this, x, y, x + 1, y, false);
			blackMoves.add(theMove);
		}

		// move left
		if (!getBoard().occupied(x - 1, y)) {
			theMove = new Move(this, x, y, x - 1, y, false);
			blackMoves.add(theMove);
		}
		return blackMoves;
	}
}