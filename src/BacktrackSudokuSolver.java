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
			if (this.isValidAddition(emptyRow, emptyColumn, value)) {
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
	
	// Static functions
	// Check if the adding a value to the sudoku will invalidate it
	// This should only be used if the current Sudoku board is already validated
	private boolean isValidAddition(int row, int column, int value) {
		if (value < 1 || value > 9) return false; // Invalid if number is not inclusive of 1-9
		if (!this.board.isEmpty(row, column)) return false; // Invalid if row and column already has a value
		
		HashMap<Integer, Integer> rowMap = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> columnMap = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> boxMap = new HashMap<Integer, Integer>();
		
		int boxRowStart = row - row % Board.SMALL_BOX_ROWS;
        int boxColStart = column - column % Board.SMALL_BOX_COLUMNS;
		for (int i = 0; i < Board.NUM_ROWS; i++) {
			if (!this.board.isEmpty(row, i)) rowMap.put(this.board.getValue(row, i), 1);				// Row
			if (!this.board.isEmpty(i, column)) columnMap.put(this.board.getValue(i, column), 1);	// Column
			
			if (i >= boxRowStart && i < boxRowStart + Board.SMALL_BOX_ROWS) // Box
				for (int g = boxColStart; g < boxColStart + Board.SMALL_BOX_COLUMNS; g++)
					if (!this.board.isEmpty(i, g)) boxMap.put(this.board.getValue(i, g), 1);
		}
		
		return !(rowMap.containsKey(value) || columnMap.containsKey(value) || boxMap.containsKey(value));
	}
}