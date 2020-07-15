/**
 * GraphicDisplay.java
 * 
 * Class for displaying the board on a JPanel
 * 
 */
package assignment2018;

import java.awt.*;
import java.net.URL;

import assignment2018.codeprovided.*;

import javax.swing.*;

public class GraphicDisplay extends JFrame implements Display {
	private Pieces p;
	private JButton[][] but = new JButton[8][8];
	private Container contentPane = getContentPane();

	// constructor
	public GraphicDisplay() {

		setTitle("chess");
		setSize(650, 650);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		/*
		 * Toolkit toolkit = Toolkit.getDefaultToolkit(); Dimension screenDimensions =
		 * toolkit.getScreenSize();
		 * setSize(screenDimensions.width/2,screenDimensions.height/2); setLocation(new
		 * Point(screenDimensions.width/4,screenDimensions.height/4));
		 */

		contentPane.setLayout(new GridLayout(9, 10));
		JButton[][] but = new JButton[8][8];
	}

	@Override
	public void displayBoard(Pieces myPieces) {

		contentPane.validate();
		contentPane.removeAll();

		contentPane.repaint();
		p = myPieces;
		Board b = myPieces.getPiece(0).getBoard();
		JLabel l;
		char z;
		contentPane.add(new JLabel(" "));
		for (int k = 0; k <= 7; k++) {
			z = (char) (65 + k);
			String y = Character.toString(z);
			l = new JLabel(y);
			contentPane.add(l);
		}

		for (int j = 7; j >= 0; j--) {
			l = new JLabel(Integer.toString(j + 1));
			contentPane.add(l);
			for (int i = 0; i <= 7; i++) {
				// setting the icons on the buttons
				if (b.getPiece(i, j) != null) {
					but[i][j] = new JButton();
					switch (b.getPiece(i, j).toString()) {
					case "p":
						URL img = getClass().getResource("/assignment2018/images/p.png");
						but[i][j].setIcon(new ImageIcon(img));
						break;
					case "P":
						img = getClass().getResource("/assignment2018/images/bp.png");
						but[i][j].setIcon(new ImageIcon(img));
						break;
					case "b":
						img = getClass().getResource("/assignment2018/images/b.png");
						but[i][j].setIcon(new ImageIcon(img));
						break;
					case "B":
						img = getClass().getResource("/assignment2018/images/bb.png");
						but[i][j].setIcon(new ImageIcon(img));
						break;
					case "n":
						img = getClass().getResource("/assignment2018/images/n.png");
						but[i][j].setIcon(new ImageIcon(img));
						break;
					case "N":
						img = getClass().getResource("/assignment2018/images/bn.png");
						but[i][j].setIcon(new ImageIcon(img));
						break;
					case "q":
						img = getClass().getResource("/assignment2018/images/q.png");
						but[i][j].setIcon(new ImageIcon(img));
						break;
					case "Q":
						img = getClass().getResource("/assignment2018/images/bq.png");
						but[i][j].setIcon(new ImageIcon(img));
						break;
					case "k":
						img = getClass().getResource("/assignment2018/images/k.png");
						but[i][j].setIcon(new ImageIcon(img));
						break;
					case "K":
						img = getClass().getResource("/assignment2018/images/bk.png");
						but[i][j].setIcon(new ImageIcon(img));
						break;
					case "r":
						img = getClass().getResource("/assignment2018/images/r.png");
						but[i][j].setIcon(new ImageIcon(img));
						break;
					case "R":
						img = getClass().getResource("/assignment2018/images/br.png");
						but[i][j].setIcon(new ImageIcon(img));
						break;
					}

				} else
					but[i][j] = new JButton(" ");

				Color brown;
				if ((i + j) % 2 != 1) {
					// coloring the tiles
					brown = new Color(100, 50, 0);
					but[i][j].setBackground(brown);
				} else
					but[i][j].setBackground(Color.WHITE);
				contentPane.add(but[i][j]);
			}
		}

		contentPane.validate();
		// contentPane.repaint();

	}
}
