import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;


public class BoardDisplay extends JPanel{

	private Board board;
	
	public BoardDisplay() {
		this.board = new Board();
		
		// Layout of items
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		c.fill = GridBagConstraints.BOTH;
		for (int row = 0; row < Board.NUM_ROWS; row++) {
			for (int column = 0; column < Board.NUM_COLUMNS; column++) {
				c.gridx = row;
				c.gridy = column;
				Cell cell = new Cell(row, column);
				cell.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
				this.add(cell, c);
			}
		}
	}
}
