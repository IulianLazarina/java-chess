/**
 * RandomPlayer.java
 * 
 * Class for a chess player that makes random moves
 */

package assignment2018;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;

import assignment2018.codeprovided.*;

public class RandomPlayer extends Player {
	Scanner sc = new Scanner(System.in);
	private Board b;
	boolean gameover;

	public RandomPlayer(String n, Pieces p, Board ib, Player o) {
		super(n, p, ib, o);
		b = ib;
	}

	public Board getBoard() {
		return b;

	}

	public ArrayList<Move> getMoves(Board b, int x, int y) {
		if (b.getPiece(x, y) != null)
			return b.getPiece(x, y).availableMoves();
		else
			return null;
	}

	// 65-72
	// 48-56
	public boolean makeMove() {

		gameover = false;
		System.out.println();

		// String si = sc.next();
		// String sn = sc.next();
		Board b = this.getBoard();

		Random r = new Random();
		int piecen = r.nextInt(this.getPieces().getNumPieces());
		int x = this.getPieces().getPiece(piecen).getX();
		int y = this.getPieces().getPiece(piecen).getY();

		while (getMoves(b, x, y) == null || getMoves(b, x, y).size() == 0) {
			piecen = r.nextInt(this.getPieces().getNumPieces());
			x = this.getPieces().getPiece(piecen).getX();
			y = this.getPieces().getPiece(piecen).getY();
		}
		boolean ex = false;
		ArrayList<Move> mo = getMoves(b, x, y);

		int count = mo.size();
		int index = Math.abs(r.nextInt(Math.abs(count)));
		Move move = mo.get(index);

		int i = move.getI();
		int j = move.getJ();

		while (i < 0 || j < 0 || i > 7 || j > 7) {

			r = new Random();
			piecen = r.nextInt(this.getPieces().getNumPieces());
			x = this.getPieces().getPiece(piecen).getX();
			y = this.getPieces().getPiece(piecen).getY();

			while (getMoves(b, x, y) == null || getMoves(b, x, y).size() == 0) {
				piecen = r.nextInt(this.getPieces().getNumPieces());
				x = this.getPieces().getPiece(piecen).getX();
				y = this.getPieces().getPiece(piecen).getY();
			}

			mo = getMoves(b, x, y);

			count = mo.size();
			index = Math.abs(r.nextInt(Math.abs(count)));
			move = mo.get(index);

			i = move.getI();
			j = move.getJ();

		}

		Piece a = b.getPiece(x, y);
		Piece n = b.getPiece(i, j);

		if (isSameColour(x, y)) {
			if (isAvailable(mo, move)) {
				if (flag(i, j, move)) {
					if (n.getColourChar() == getPieces().getPiece(0).getColourChar()) {
						System.out.println("illegal move");
						return false;
					}
					setGameOver(n);
					if (gameover == true)
						System.out.println("Game Over");
					b.remove(i, j);
					getOpponent().deletePiece(n);
					a.setPosition(i, j);
					b.setPosition(i, j, a);
					b.remove(x, y);
					return true;
				} else {
					a.setPosition(i, j);
					b.setPosition(i, j, a);
					b.remove(x, y);
					return true;
				}
			} else
				return false;
		} else {
			System.out.println("Wrong piece");
			return false;
		}
	}

	public boolean getGameOver() {
		return gameover;
	}

	public void pickPiece() {

	}

	public boolean isSameColour(int x, int y) {
		if (this.getPieces().getPiece(0).getColour() == b.getPiece(x, y).getColour())
			return true;
		return false;
	}

	public boolean flag(int i, int j, Move move) {
		if (b.occupied(i, j)) {
			move.setTake(true);
			return true;
		}
		return false;
	}

	public boolean isAvailable(ArrayList<Move> mo, Move move) {
		if (mo != null) {
			for (Move m : mo) {
				if (m.equals(move))
					return true;
			}

		}
		return false;

	}

	public void setGameOver(Piece n) {
		if (b != null)
			if (n.getChar() == 'K' || n.getChar() == 'k')
				gameover = true;
	}

}
