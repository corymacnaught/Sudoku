import java.util.Arrays;
import java.util.HashMap;

public class Board {
	
	public final static int NUM_ROWS = 9;
	public final static int NUM_COLUMNS = 9;
	
	private final static int SMALL_BOX_ROWS = (int) Math.sqrt(NUM_ROWS);
	private final static int SMALL_BOX_COLUMNS = (int) Math.sqrt(NUM_COLUMNS);
	
	public final static int NUM_BOXES = SMALL_BOX_ROWS * SMALL_BOX_COLUMNS;
	
	//first number = rows, second number = columns
	
	private int[][] grid;
	
	public Board(int[][] grid) {
		this.grid = Board.isValidGrid(grid) ? grid : Board.generateRandomSudokuGrid();
	}
	
	// Solve the current board
	public void solve() {
		this.solve(0, 0);
	}
	
	private boolean solve(int row, int column) {
		// Determine next available empty space
		// If no empty space return grid
		
		// row = index / NUM_COLUMNS
		// column = index % NUM_COLUMNS
		int emptyRow = 0;
		int emptyColumn = 0;
		for (int i = row * NUM_COLUMNS + column; i <= NUM_COLUMNS * NUM_ROWS; i++) {
			if (i == NUM_ROWS * NUM_COLUMNS) return true;
			
			int r = i / NUM_COLUMNS;
			int c = i % NUM_COLUMNS;
			if (this.grid[r][c] == 0) {
				emptyRow = r;
				emptyColumn = c;
				break;
			}
		}
		
		// Check validity of adding numbers in order from 1 to 9
		// If no valid number back track
		for (int value = 1; value <= 9; value++) {
			//System.out.println("Row = " + emptyRow + " : Column = " + emptyColumn + " : Value = " + value + " : IsValidEntry = " + this.isValidAddition(emptyRow, emptyColumn, value));
			if (this.isValidAddition(emptyRow, emptyColumn, value)) {
				this.grid[emptyRow][emptyColumn] = value;
				if (this.solve(emptyRow, emptyColumn)) {
					//System.out.println(this.toString());
					return true;
				}
				this.grid[emptyRow][emptyColumn] = 0;
			}
		}
		
		return false;
	}
	
	public boolean isValid() {
		return Board.isValidGrid(this.grid);
	}
	
	// Static functions
	// Check if the adding a value to the sudoku will invalidate it
	// This should only be used if the current Sudoku board is already validated
	public boolean isValidAddition(int row, int column, int value) {
		if (value < 1 || value > 9) return false; // Invalid if number is not inclusive of 1-9
		if (grid[row][column] != 0) return false; // Invalid if row and column already has a value
		
		HashMap<Integer, Integer> rowMap = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> columnMap = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> boxMap = new HashMap<Integer, Integer>();
		
		int boxRowStart = row - row % SMALL_BOX_ROWS;
        int boxColStart = column - column % SMALL_BOX_COLUMNS;
		for (int i = 0; i < NUM_ROWS; i++) {
			if (grid[row][i] != 0) rowMap.put(grid[row][i], 1);				// Row
			if (grid[i][column] != 0) columnMap.put(grid[i][column], 1);	// Column
			
			if (i >= boxRowStart && i < boxRowStart + SMALL_BOX_ROWS) // Box
				for (int g = boxColStart; g < boxColStart + SMALL_BOX_COLUMNS; g++)
					if (grid[i][g] != 0) boxMap.put(grid[i][g], 1);
		}
		
		return !(rowMap.containsKey(value) || columnMap.containsKey(value) || boxMap.containsKey(value));
	}
	
	private static int countSolutions(int[][] grid) {
		return Board.countSolutions(new Board(grid));
	}
	
	private static int countSolutions(Board board) {
		return 0;
	}
	
	// Check if the current Sudoku is Valid
	public static boolean isValidGrid(int[][] grid) {
		if (grid.length != NUM_COLUMNS) return false; // Not valid if a column length is more or less than 9
		
		HashMap<Integer, Integer>[] rows = new HashMap[NUM_ROWS];
		HashMap<Integer, Integer>[] columns = new HashMap[NUM_COLUMNS];
		HashMap<Integer, Integer>[] boxes = new HashMap[NUM_BOXES];
		
		for (int i = 0; i < rows.length; i++) {
			rows[i] = new HashMap<Integer, Integer>();
			columns[i] = new HashMap<Integer, Integer>();
			boxes[i] = new HashMap<Integer, Integer>();
		}
		
		for (int row = 0; row < Board.NUM_ROWS; row++) {
			if (grid[row].length != NUM_ROWS) return false; // Not valid if a row length is more or less than 9
			
			for (int column = 0; column < Board.NUM_COLUMNS; column++) {
				
				int value = grid[row][column];
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
	
	// Generates a board with one solution
	public static int[][] generateRandomSudokuGrid() {
		int[][] nullGrid = { { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
       		 { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
       		 { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
       		 { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
       		 { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
       		 { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
       		 { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
       		 { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
       		 { 0, 0, 0, 0, 0, 0, 0, 0, 0 } };
		
		return nullGrid;
	}
	
	// Get the box that the row/column is in
	//{0,1,2}
	//{3,4,5}
	//{6,7,8}
	//	 0,1,2,3,4,5,6,7,8
	// 0{0,0,0,1,1,1,2,2,2}
	// 1{0,0,0,1,1,1,2,2,2}
	// 2{0,0,0,1,1,1,2,2,2}
	// 3{3,3,3,4,4,4,5,5,5}
	// 4{3,3,3,4,4,4,5,5,5}
	// 5{3,3,3,4,4,4,5,5,5}
	// 6{6,6,6,7,7,7,8,8,8}
	// 7{6,6,6,7,7,7,8,8,8}
	// 8{6,6,6,7,7,7,8,8,8}
	public static int calculateSudokuBox(int row, int column) {
		
		return row / SMALL_BOX_ROWS * SMALL_BOX_COLUMNS + column / SMALL_BOX_COLUMNS;
	}
	
	public String toString() {
		String s = "";
		for (int[] array : grid) s += Arrays.toString(array) + "\n";
		return s;
	}
}
