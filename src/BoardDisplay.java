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
		
		board.addBoardEventListener(new BoardEventListener()
		{
			@Override
			public void boardEventOccurred(BoardEvent evt)
			{
				System.out.println("Row = " + evt.getObject().row + " : Column = " + evt.getObject().column + " : Value = " + evt.getObject().value + " : IsValidEntry = " + board.isValidAddition(evt.getObject().row, evt.getObject().column, evt.getObject().value));
				updateCell(evt.getObject().row, evt.getObject().column, evt.getObject().value);
				for (int i = 0; i < 5000; i++) {
					System.out.println("Slow down");
				}
			}
		});
	}
	
	public void solveSudoku() {
		this.board.solve();
	}
	
	private void updateCells() {
		for (int row = 0; row < Board.NUM_ROWS; row++) {
			for (int column = 0; column < Board.NUM_COLUMNS; column++) {
				this.updateCell(row, column, this.board.getValue(row, column));
			}
		}
	}
	
	private void updateCell(int row, int column, int value) {
		this.cells[row][column].setValue(value);
	}
}
