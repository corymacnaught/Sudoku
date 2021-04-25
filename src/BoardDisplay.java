import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;


public class BoardDisplay extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Board board;
	private Cell[][] cells = new Cell[Board.NUM_ROWS][Board.NUM_COLUMNS];
	
	public BoardDisplay(int[][] grid) {
		this.board = new Board(grid);
		
		// Layout of cells
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		c.fill = GridBagConstraints.BOTH;
		for (int row = 0; row < Board.NUM_ROWS; row++) {
			for (int column = 0; column < Board.NUM_COLUMNS; column++) {
				c.gridx = row;
				c.gridy = column;
				c.weightx = 1.0;
				c.weighty = 1.0;
				cells[row][column] = new Cell(row, column);
				cells[row][column].setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
				this.add(cells[row][column], c);
			}
		}
		
		this.updateCells();
	}
	
	public void solveSudoku() {
		this.board.solve();
		this.updateCells();
	}
	
	private void updateCells() {
		for (int row = 0; row < Board.NUM_ROWS; row++) {
			for (int column = 0; column < Board.NUM_COLUMNS; column++) {
				this.cells[row][column].setValue(this.board.getValue(row, column));
			}
		}
	}
}
