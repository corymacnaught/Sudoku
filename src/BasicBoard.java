import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class BasicBoard extends Board {
	
	//first number = rows, second number = columns
	
	public BasicBoard(int[][] grid) throws Exception{
		super(grid);
	}
	
	@Override
	public boolean isValid() {
		if (this.board.length != NUM_COLUMNS) return false; // Not valid if a column length is more or less than 9
		
		HashMap<Integer, Integer>[] rows = new HashMap[NUM_ROWS];
		HashMap<Integer, Integer>[] columns = new HashMap[NUM_COLUMNS];
		HashMap<Integer, Integer>[] boxes = new HashMap[NUM_BOXES];
		
		for (int i = 0; i < rows.length; i++) {
			rows[i] = new HashMap<Integer, Integer>();
			columns[i] = new HashMap<Integer, Integer>();
			boxes[i] = new HashMap<Integer, Integer>();
		}
		
		for (int row = 0; row < BasicBoard.NUM_ROWS; row++) {
			if (this.board[row].length != NUM_ROWS) return false; // Not valid if a row length is more or less than 9
			
			for (int column = 0; column < BasicBoard.NUM_COLUMNS; column++) {
				
				int value = this.board[row][column].getValue();
				if (value == 0) continue; // 0 = empty space
				if (value < 1 || value > 9) return false; // numbers should only be between 1 and 9
				
				int box = Board.calculateSudokuBox(row, column);
				HashMap<Integer, Integer> rowMap = rows[row];
				HashMap<Integer, Integer> columnMap = columns[column];
				HashMap<Integer, Integer> boxMap = boxes[box];
				
				// Check if the value is already in the current row, column or box
				// If if is, return false
				// Otherwise, put the value in the row, column and box
				if (rowMap.containsKey(value) || columnMap.containsKey(value) || boxMap.containsKey(value)) return false;
				
				rowMap.put(value, 1);
				columnMap.put(value, 1);
				boxMap.put(value, 1);
			}
		}
		
		return true;
	}
	
	// Static functions
	// Check if the adding a value to the sudoku will invalidate it
	// This should only be used if the current Sudoku board is already validated
	@Override
	public boolean isValidAddition(int row, int column, int value) {
		if (value < 1 || value > 9) return false; // Invalid if number is not inclusive of 1-9
		if (!this.isEmpty(row, column)) return false; // Invalid if row and column already has a value
		
		HashMap<Integer, Integer> rowMap = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> columnMap = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> boxMap = new HashMap<Integer, Integer>();
		
		int boxRowStart = row - row % Board.SMALL_BOX_ROWS;
        int boxColStart = column - column % Board.SMALL_BOX_COLUMNS;
		for (int i = 0; i < Board.NUM_ROWS; i++) {
			if (!this.isEmpty(row, i)) rowMap.put(this.getValue(row, i), 1);				// Row
			if (!this.isEmpty(i, column)) columnMap.put(this.getValue(i, column), 1);	// Column
			
			if (i >= boxRowStart && i < boxRowStart + Board.SMALL_BOX_ROWS) // Box
				for (int g = boxColStart; g < boxColStart + Board.SMALL_BOX_COLUMNS; g++)
					if (!this.isEmpty(i, g)) boxMap.put(this.getValue(i, g), 1);
		}
		
		return !(rowMap.containsKey(value) || columnMap.containsKey(value) || boxMap.containsKey(value));
	}
}
