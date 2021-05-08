import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;


public class BoardDisplay extends JPanel implements Runnable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Board board;
	private Cell[][] cells = new Cell[Board.NUM_ROWS][Board.NUM_COLUMNS];
	Thread t;
	
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
				cells[row][column].setBorder(BorderFactory.createLineBorder(Color.BLACK));
				this.add(cells[row][column], c);
			}
		}
		
		this.updateCells();
		
		board.addBoardEventListener(new BoardEventListener()
		{
			@Override
			public void boardEventOccurred(BoardEvent evt)
			{
				Cell cell = cells[evt.getObject().row][evt.getObject().column];
				cell.setBorder(BorderFactory.createLineBorder(Color.GREEN));
				updateCell(evt.getObject().row, evt.getObject().column, evt.getObject().value);
				
				try { Thread.sleep(100); }
				catch (InterruptedException e) { e.printStackTrace(); }

				cell.setBorder(BorderFactory.createLineBorder(Color.RED));
			}
		});
	}
	
	public void solveSudoku() {
		Thread t = new Thread(this);
		t.start();
	}
	
	private void updateCells() {
		for (int row = 0; row < Board.NUM_ROWS; row++) {
			for (int column = 0; column < Board.NUM_COLUMNS; column++) {
				this.updateCell(row, column, this.board.getValue(row, column));
			}
		}
	}
	
	private void updateCell(int row, int column, int value) {
		Cell cell = this.cells[row][column];
		cell.setValue(value);
	}

	@Override
	public void run() {
		this.board.solve();
	}
}
