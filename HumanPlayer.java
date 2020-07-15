/**
 * HumanPLayer.java
 * 
 * Class for a human chess player
 * 
 */
package assignment2018;

import assignment2018.codeprovided.*;

import java.util.ArrayList;
import java.util.Scanner;

public class HumanPlayer extends Player {

	Scanner sc = new Scanner(System.in);
	private Board b;
	private boolean gameOver;

	public HumanPlayer(String n, Pieces p, Board ib, Player o) {
		super(n, p, ib, o);
		b = ib;
	}

	// method that returns the board
	public Board getBoard() {
		return b;

	}

	// method that returns an Arraylist of available moves
	public ArrayList<Move> getMoves(Board b, int x, int y) {
		if (b.getPiece(x, y) != null)
			return b.getPiece(x, y).availableMoves();
		else
			return null;
	}

	// 65-72
	// 48-56
	public boolean makeMove() {

		gameOver = false;
		System.out.println();

		// reading the coords
		String si = sc.next();
		String sn = sc.next();
		Board b = this.getBoard();

		// separating the initial and final coords of the move
		int x = (int) Character.toUpperCase(si.charAt(0)) - 65;
		int y = (int) Character.toUpperCase(si.charAt(1)) - 49;

		int i = (int) Character.toUpperCase(sn.charAt(0)) - 65;
		int j = (int) Character.toUpperCase(sn.charAt(1)) - 49;
		if (x < 0 || x > 7 || y < 0 || y > 7) {
			System.out.println("illegal move");

			return false;
		}
		Move move = new Move(b.getPiece(x, y), x, y, i, j, false);
		ArrayList<Move> mo = getMoves(b, x, y);

		Piece a = b.getPiece(x, y);
		Piece n = b.getPiece(i, j);

		if (isSameColour(x, y)) {
			if (isAvailable(mo, move)) {
				if (flag(i, j, move)) {
					if (n.getColourChar() == getPieces().getPiece(1).getColourChar()) {
						System.out.println("illegal move");
						return false;
					}
					setgameOver(n);
					if (gameOver == true)
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
			} else {
				System.out.println("invalid move");
				return false;
			}
		} else {
			System.out.println("Wrong piece");
			return false;
		}

	}

	// method for returning if the game is over
	public boolean getGameOver() {
		return gameOver;
	}

	// method that returns true if the selected piece is of the
	// same colour as the player's
	public boolean isSameColour(int x, int y) {
		if (this.getPieces().getPiece(0).getColour() == b.getPiece(x, y).getColour())
			return true;
		return false;
	}

	// method that returns true if the next move will take a piece
	public boolean flag(int i, int j, Move move) {
		if (b.occupied(i, j)) {
			move.setTake(true);
			return true;
		}
		return false;
	}

	// method that returns true if a move is available
	public boolean isAvailable(ArrayList<Move> mo, Move move) {
		if (mo != null) {
			for (Move m : mo) {
				if (m.equals(move))
					return true;
			}

		}
		return false;

	}

	// method that sets gameOver to true if a king is taken
	public void setgameOver(Piece n) {
		if (b != null)
			if (n.getChar() == 'K' || n.getChar() == 'k')
				gameOver = true;
	}

}
