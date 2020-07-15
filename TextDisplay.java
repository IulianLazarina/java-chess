/**
 * TextDisplay.java
 * 
 * Class for displaying the chess board in the terminal
 * 	implements Display.java
 */

package assignment2018;

import assignment2018.codeprovided.*;

public class TextDisplay implements Display {
	private Board b;

	public TextDisplay(Board ib) {
		b = ib;
	}

	public Board getBoard() {
		return b;
	}

	public void displayBoard(Pieces myPieces) {
		Board b = this.getBoard();
		System.out.println(" |ABCDEFGH");
		System.out.print("----------");
		for (int j = 7; j >= 0; j--) {
			System.out.println();
			System.out.print(j + 1 + "|");
			for (int i = 0; i <= 7; i++) {
				if (b.getPiece(i, j) != null)// &&b.getPiece(i,j).getColour()!=WHITE)
					System.out.print(b.getPiece(i, j).toString());
				else
					System.out.print('.');
			}
		}
	}

}
