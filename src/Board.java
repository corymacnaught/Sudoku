import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public abstract class Board {
	public final static int NUM_ROWS = 9;
	public final static int NUM_COLUMNS = 9;
	
	protected final static int SMALL_BOX_ROWS = (int) Math.sqrt(NUM_ROWS);
	protected final static int SMALL_BOX_COLUMNS = (int) Math.sqrt(NUM_COLUMNS);
	
	public final static int NUM_BOXES = SMALL_BOX_ROWS * SMALL_BOX_COLUMNS;
	
	protected Cell[][] board;
	
	//first number = rows, second number = columns
	
	public Board(int[][] grid) throws Exception {
		if (Board.gridIsProperSize(grid)) {
			Cell[][] board = Board.gridToBoard(grid);
			this.board = board;
		}else {
			throw new Exception("Board is not the proper size");
		}
	}
	
	public abstract boolean isValid();
	
	public abstract boolean isValidAddition(int row, int column, int value);
	
	public static boolean gridIsProperSize(int[][] grid) {
		if (grid.length != NUM_COLUMNS) return false;
		for (int row = 0; row < Board.NUM_ROWS; row++) {
			if (grid[row].length != NUM_ROWS) return false;
		}
		
		return true;
	}
	
	protected static Cell[][] gridToBoard(int[][] grid) {
		Cell[][] board = new Cell[Board.NUM_ROWS][Board.NUM_COLUMNS];
		
		for (int row = 0; row < Board.NUM_ROWS; row++) {
			for (int column = 0; column < Board.NUM_COLUMNS; column++) {
				board[row][column] = new Cell(grid[row][column]);
			}
		}
		
		return board;
	}
	
	// Generates a board with one solution
	//public abstract static int[][] generateRandomSudokuGrid();
	
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
	
	public int getValue(int row, int column) {
		return board[row][column].getValue();
	}
	
	public void setValue(int row, int column, int value) {
		this.board[row][column].setValue(value);
	}
	
	public boolean isEmpty(int row, int column) {
		return this.board[row][column].isEmpty();
	}
	
	public String toString() {
		String s = "";
		for (Cell[] array : board) s += Arrays.toString(array) + "\n";
		return s;
	}
}
