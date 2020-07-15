/**
 * Knight.java
 * 
 * Class for the knight piece
 */

package assignment2018;

import assignment2018.codeprovided.*;
import assignment2018.codeprovided.Piece;
import assignment2018.codeprovided.PieceCode;

import java.util.*;

import assignment2018.Move;

public class Knight extends Piece {

	public Knight(int ix, int iy, int c, Board b) {
		super(PieceCode.KNIGHT, ix, iy, c, b);
	}

	// method implements abstract availableMoves method in Piece class
	public ArrayList<Move> availableMoves() {
		if (getColour() == PieceCode.WHITE)
			return whiteKnight();
		else
			return blackKnight();
	}

	// method to return list of legal moves for a white Knight
	private ArrayList<Move> whiteKnight() {
		// obtain current co-ordinates
		int x = this.getX();
		int y = this.getY();

		// create a new vector to store legal whiteMoves
		ArrayList<Move> whiteMoves = new ArrayList<Move>();

		// set up m to refer to a Move object
		Move theMove = null;

		// available moves
		// y+2 x+1

		theMove = new Move(this, x, y, x + 1, y + 2, false);
		whiteMoves.add(theMove);

		// y+1 x+2

		theMove = new Move(this, x, y, x + 2, y + 1, false);
		whiteMoves.add(theMove);

		// y-1 x+2

		theMove = new Move(this, x, y, x + 2, y - 1, false);
		whiteMoves.add(theMove);

		// y-2 x+1

		theMove = new Move(this, x, y, x + 1, y - 2, false);
		whiteMoves.add(theMove);

		// y-2 x-1

		theMove = new Move(this, x, y, x - 1, y - 2, false);
		whiteMoves.add(theMove);

		// y-1 x-2

		theMove = new Move(this, x, y, x - 2, y - 1, false);
		whiteMoves.add(theMove);

		// y+1 x-2

		theMove = new Move(this, x, y, x - 2, y + 1, false);
		whiteMoves.add(theMove);

		// y+2 x-1

		theMove = new Move(this, x, y, x - 1, y + 2, false);
		whiteMoves.add(theMove);

		return whiteMoves;
	}

	// method to return list of legal moves for a black Knight
	private ArrayList<Move> blackKnight() {
		// obtain current co-ordinates
		int x = this.getX();
		int y = this.getY();

		// return null if the Knight is at the edge of the board, or if the
		// next move takes it out of range

		// otherwise create a new vector to store legal blackMoves
		ArrayList<Move> blackMoves = new ArrayList<Move>();

		// set up m to refer to a Move object
		Move theMove = null;

		// available moves
		// y+2 x+1
		if (!getBoard().occupied(x + 1, y + 2)) {
			theMove = new Move(this, x, y, x + 1, y + 2, false);
			blackMoves.add(theMove);
		}
		// y+1 x+2
		if (!getBoard().occupied(x + 2, y + 1)) {
			theMove = new Move(this, x, y, x + 2, y + 1, false);
			blackMoves.add(theMove);
		}
		// y-1 x+2
		if (!getBoard().occupied(x + 2, y - 1)) {
			theMove = new Move(this, x, y, x + 2, y - 1, false);
			blackMoves.add(theMove);
		}
		// y-2 x+1
		if (!getBoard().occupied(x + 1, y - 2)) {
			theMove = new Move(this, x, y, x + 1, y - 2, false);
			blackMoves.add(theMove);
		}
		// y-2 x-1
		if (!getBoard().occupied(x - 1, y - 2)) {
			theMove = new Move(this, x, y, x - 1, y - 2, false);
			blackMoves.add(theMove);
		}
		// y-1 x-2
		if (!getBoard().occupied(x - 2, y - 1)) {
			theMove = new Move(this, x, y, x - 2, y - 1, false);
			blackMoves.add(theMove);
		}
		// y+1 x-2
		if (!getBoard().occupied(x - 2, y + 1)) {
			theMove = new Move(this, x, y, x - 2, y + 1, false);
			blackMoves.add(theMove);
		}
		// y+2 x-1
		if (!getBoard().occupied(x - 1, y + 2)) {
			theMove = new Move(this, x, y, x - 1, y + 2, false);
			blackMoves.add(theMove);
		}
		return blackMoves;
	}
}