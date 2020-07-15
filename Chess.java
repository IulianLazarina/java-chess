/**
 * Chess.java
 * 
 * main class for running the chess game and choosing the type of player
 * 
 * 
 */

package assignment2018;

import assignment2018.codeprovided.*;
import java.util.*;

public class Chess {
	// private static final int WHITE = 1;

	public static void main(String[] args) {
		Board b = new Board();

		Pieces myPieces = new Pieces(b, 1);
		Pieces blackPieces = new Pieces(b, 0);

		TextDisplay d = new TextDisplay(b);

		d.displayBoard(myPieces);

		// any combination of players can be picked here

		/*
		 * HumanPlayer blackPlayer = new HumanPlayer("Human2",blackPieces, b, null);
		 * HumanPlayer whitePlayer = new HumanPlayer("Human",myPieces, b, null);
		 */

		RandomPlayer blackPlayer = new RandomPlayer("random", blackPieces, b, null);
		RandomPlayer whitePlayer = new RandomPlayer("random", myPieces, b, null);

		/*
		 * AggressivePlayer blackPlayer = new AggressivePlayer("aggressive",blackPieces,
		 * b, null); AggressivePlayer whitePlayer = new
		 * AggressivePlayer("aggressive",myPieces, b, null);
		 */

		blackPlayer.setOpponent(whitePlayer);
		whitePlayer.setOpponent(blackPlayer);

		GraphicDisplay thy = new GraphicDisplay();
		thy.displayBoard(myPieces);
		boolean whiteMove = true;
		boolean blackMove = false;

		// while loop that continues the game until a king is taken
		while (!whitePlayer.getGameOver() && !blackPlayer.getGameOver()) {
			if (whiteMove) {
				while (whiteMove) {
					System.out.println();
					System.out.println();
					System.out.println("White to move");
					if (whitePlayer.makeMove()) {
						whiteMove = false;
						blackMove = true;
						d.displayBoard(myPieces);
						thy.displayBoard(myPieces);
					}
				}
			} else {
				while (blackMove) {
					System.out.println();
					System.out.println();
					System.out.println("Black to move");
					if (blackPlayer.makeMove()) {
						blackMove = false;
						whiteMove = true;
						d.displayBoard(myPieces);
						thy.displayBoard(myPieces);
					}
				}
			}
			if (whitePlayer.getGameOver() || blackPlayer.getGameOver())
				break;

		}
	}
}
