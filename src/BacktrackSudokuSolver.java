import java.util.HashMap;

public class BacktrackSudokuSolver extends SudokuSolver{
	
	public BacktrackSudokuSolver(Board board) {
		this.board = board;
	}
	
	protected boolean solve(int row, int column) {
		// Determine next available empty space
		// If no empty space return grid
		
		// row = index / NUM_COLUMNS
		// column = index % NUM_COLUMNS
		int index = this.findNextEmptySpace(row, column);
		if (index == -1) return true;
		
		int emptyRow = index / Board.NUM_COLUMNS;
		int emptyColumn = index % Board.NUM_COLUMNS;
		
		return this.backtrack(emptyRow, emptyColumn);
	}
	
	private int findNextEmptySpace(int row, int column) {
		for (int i = row * Board.NUM_COLUMNS + column; i < Board.NUM_COLUMNS * Board.NUM_ROWS; i++)
			if (this.board.isEmpty(i / Board.NUM_COLUMNS, i % Board.NUM_COLUMNS)) return i;
		
		return -1;
	}
	
	// Check validity of adding numbers in order from 1 to 9
			// If no valid number back track
	private boolean backtrack(int emptyRow, int emptyColumn) {
		for (int value = 1; value <= 9; value++) {
			//System.out.println("Row = " + emptyRow + " : Column = " + emptyColumn + " : Value = " + value + " : IsValidEntry = " + this.isValidAddition(emptyRow, emptyColumn, value));
			//fireDisplayEvent(new BoardEvent(new CellObject(emptyRow, emptyColumn, value)));
			if (this.board.isValidAddition(emptyRow, emptyColumn, value)) {
				this.board.setValue(emptyRow, emptyColumn, value);
				if (this.solve(emptyRow, emptyColumn)) {
					//System.out.println(this.toString());
					return true;
				}
				this.board.setValue(emptyRow, emptyColumn, 0);
			}
		}
		
		return false;
	}
}
