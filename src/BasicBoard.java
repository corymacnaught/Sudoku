import java.util.Arrays;
import java.util.HashMap;

public class BasicBoard extends Board {
	
	public final static int NUM_ROWS = 9;
	public final static int NUM_COLUMNS = 9;
	
	private final static int SMALL_BOX_ROWS = (int) Math.sqrt(NUM_ROWS);
	private final static int SMALL_BOX_COLUMNS = (int) Math.sqrt(NUM_COLUMNS);
	
	public final static int NUM_BOXES = SMALL_BOX_ROWS * SMALL_BOX_COLUMNS;
	
	//first number = rows, second number = columns
	
	private Cell[][] board;
	
	public BasicBoard(int[][] grid) {
		Cell[][] board = BasicBoard.gridToBoard(grid);
		this.board = BasicBoard.isValidBoard(board) ? board : BasicBoard.gridToBoard(BasicBoard.generateRandomSudokuGrid());
	}
	
	// Solve the current board
	public void solve() {
		this.solve(0, 0);
	}
	
	protected boolean solve(int row, int column) {
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
			if (this.board[r][c].isEmpty()) {
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
				this.board[emptyRow][emptyColumn].setValue(value);
				if (this.solve(emptyRow, emptyColumn)) {
					//System.out.println(this.toString());
					return true;
				}
				this.board[emptyRow][emptyColumn].setValue(0);
			}
		}
		
		return false;
	}
	
	public boolean isValid() {
		return BasicBoard.isValidBoard(this.board);
	}
	
	// Static functions
	// Check if the adding a value to the sudoku will invalidate it
	// This should only be used if the current Sudoku board is already validated
	public boolean isValidAddition(int row, int column, int value) {
		if (value < 1 || value > 9) return false; // Invalid if number is not inclusive of 1-9
		if (!board[row][column].isEmpty()) return false; // Invalid if row and column already has a value
		
		HashMap<Integer, Integer> rowMap = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> columnMap = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> boxMap = new HashMap<Integer, Integer>();
		
		int boxRowStart = row - row % SMALL_BOX_ROWS;
        int boxColStart = column - column % SMALL_BOX_COLUMNS;
		for (int i = 0; i < NUM_ROWS; i++) {
			if (!board[row][i].isEmpty()) rowMap.put(board[row][i].getValue(), 1);				// Row
			if (!board[i][column].isEmpty()) columnMap.put(board[i][column].getValue(), 1);	// Column
			
			if (i >= boxRowStart && i < boxRowStart + SMALL_BOX_ROWS) // Box
				for (int g = boxColStart; g < boxColStart + SMALL_BOX_COLUMNS; g++)
					if (!board[i][g].isEmpty()) boxMap.put(board[i][g].getValue(), 1);
		}
		
		return !(rowMap.containsKey(value) || columnMap.containsKey(value) || boxMap.containsKey(value));
	}
	
	// Check if the current Sudoku is Valid
	public static boolean isValidBoard(Cell[][] board) {
		if (board.length != NUM_COLUMNS) return false; // Not valid if a column length is more or less than 9
		
		HashMap<Integer, Integer>[] rows = new HashMap[NUM_ROWS];
		HashMap<Integer, Integer>[] columns = new HashMap[NUM_COLUMNS];
		HashMap<Integer, Integer>[] boxes = new HashMap[NUM_BOXES];
		
		for (int i = 0; i < rows.length; i++) {
			rows[i] = new HashMap<Integer, Integer>();
			columns[i] = new HashMap<Integer, Integer>();
			boxes[i] = new HashMap<Integer, Integer>();
		}
		
		for (int row = 0; row < BasicBoard.NUM_ROWS; row++) {
			if (board[row].length != NUM_ROWS) return false; // Not valid if a row length is more or less than 9
			
			for (int column = 0; column < BasicBoard.NUM_COLUMNS; column++) {
				
				int value = board[row][column].getValue();
				if (value == 0) continue; // 0 = empty space
				if (value < 1 || value > 9) return false; // numbers should only be between 1 and 9
				
				int box = BasicBoard.calculateSudokuBox(row, column);
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
	
	public static Cell[][] gridToBoard(int[][] grid) {
		Cell[][] board = new Cell[BasicBoard.NUM_ROWS][BasicBoard.NUM_COLUMNS];
		
		for (int row = 0; row < BasicBoard.NUM_ROWS; row++) {
			for (int column = 0; column < BasicBoard.NUM_COLUMNS; column++) {
				board[row][column] = new Cell(grid[row][column]);
			}
		}
		
		return board;
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
		for (Cell[] array : board) s += Arrays.toString(array) + "\n";
		return s;
	}
}
