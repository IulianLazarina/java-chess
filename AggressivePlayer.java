package assignment2018;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import assignment2018.codeprovided.Piece;
import assignment2018.codeprovided.PieceCode;
import assignment2018.codeprovided.Pieces;
import assignment2018.codeprovided.Player;

public class AggressivePlayer extends Player {
	Scanner sc = new Scanner(System.in);
	private Board b;
	boolean gameover;
	private ArrayList<Move> am = new ArrayList<Move>();
	private ArrayList<Piece> w;
	ArrayList<Move> mo = new ArrayList<Move>();

	public AggressivePlayer(String n, Pieces p, Board ib, Player o) {
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

		for (int i = 0; i <= 7; i++) {
			for (int j = 7; j >= 0; j--) {
				if (b.getPiece(i, j) != null)
					if (isSameColour(i, j)) {
						mo = b.getPiece(i, j).availableMoves();
						for (Move m : mo) {
							if (m.getI() >= 0 && m.getJ() > 0 && m.getI() < 7 && m.getJ() < 7)
								if (b.getPiece(m.getI(), m.getJ()) != null)
									if (!isSameColour(m.getI(), m.getJ()))
										am.add(m);
						}
					}

			}
		}

		if (!am.isEmpty()) {

			Move best = null;
			int bestScore = 0;

			for (Move k : am) {
				if (k.getI() >= 0 && k.getJ() >= 0 && k.getI() < 8 && k.getJ() < 8)
					if (flag(k.getI(), k.getJ(), k))
						if (b.getPiece(k.getI(), k.getJ()) != null)
							if (PieceCode.charToInt(b.getPiece(k.getI(), k.getJ()).getChar()) >= bestScore) {
								best = k;
								bestScore = PieceCode.charToInt(b.getPiece(k.getI(), k.getJ()).getChar());
							}
			}

			x = best.getX();
			y = best.getY();
			Piece a = b.getPiece(x, y);
			Piece n = b.getPiece(best.getI(), best.getJ());
			am.clear();
			return makeMove(best, a, n, x, y, best.getI(), best.getJ());
		}

		while (getMoves(b, x, y) == null || getMoves(b, x, y).size() == 0) {
			piecen = r.nextInt(this.getPieces().getNumPieces());
			x = this.getPieces().getPiece(piecen).getX();
			y = this.getPieces().getPiece(piecen).getY();
		}
		// boolean ex = false;
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
		return makeMove(move, a, n, x, y, i, j);
	}

	private boolean makeMove(Move move, Piece a, Piece n, int x, int y, int i, int j) {
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

	public Move pickPiece() {
		ArrayList<Move> mo = null;
		for (int i = 0; i <= 7; i++) {
			for (int j = 7; j >= 0; j--) {
				if (b.getPiece(i, j) != null)
					if (isSameColour(i, j)) {
						mo = b.getPiece(i, j).availableMoves();
						for (Move m : mo) {
							am.add(m);
						}
					}
				if (mo != null) {

				}

			}
		}

		if (am != null) {

			Move best = null;
			int bestScore = 0;

			for (Move k : am) {
				if (k.getI() > 0 && k.getJ() > 0 && k.getI() < 8 && k.getJ() > 0)
					if (b.getPiece(k.getI(), k.getJ()) != null)
						if (PieceCode.charToInt(b.getPiece(k.getI(), k.getJ()).getChar()) >= bestScore) {
							best = k;
							bestScore = PieceCode.charToInt(b.getPiece(k.getI(), k.getJ()).getChar());
						}
			}

			return best;
		} else
			return null;

	}

	public boolean isSameColour(int x, int y) {
		// if (b.getPiece(x, y) != null)
		if (this.getPieces().getPiece(1).getColour() == b.getPiece(x, y).getColour())
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
