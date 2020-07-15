/**
 * Move.java
 * 
 * Class for creating moves
 */

package assignment2018;

import assignment2018.codeprovided.*;

public class Move {

	private Piece p;
	private int x;
	private int y;
	private int i;
	private int j;
	private boolean oc;

	// constructor
	public Move(Piece ip, int ox, int oy, int ni, int nj, boolean b) {
		p = ip;
		x = ox;
		y = oy;
		i = ni;
		j = nj;
		oc = b;

	}

	// returns the piece
	public Piece getPiece() {
		return p;
	}

	// returns x
	public int getX() {
		return x;
	}

	// returns y
	public int getY() {
		return y;
	}

	// returns i
	public int getI() {
		return i;
	}

	// returns j
	public int getJ() {
		return j;
	}

	// returns the take flag
	public boolean getTake() {
		return oc;
	}

	// overrides the equals method
	public boolean equals(Move move) {
		if (p == move.getPiece() && x == move.getX() && y == move.getY() && i == move.getI() && j == move.getJ())
			return true;
		else
			return false;

	}

	// toString
	public String toString() {
		System.out.println(this.getX() + " " + this.getY() + " " + this.getI() + " " + this.getJ() + " ");

		return "  ";
	}

	// sets the take fla
	public void setTake(boolean b) {
		this.oc = b;
	}

}
