import java.util.Arrays;

public abstract class Board {
	public final static int NUM_ROWS = 9;
	public final static int NUM_COLUMNS = 9;
	
	protected final static int SMALL_BOX_ROWS = (int) Math.sqrt(NUM_ROWS);
	protected final static int SMALL_BOX_COLUMNS = (int) Math.sqrt(NUM_COLUMNS);
	
	public final static int NUM_BOXES = SMALL_BOX_ROWS * SMALL_BOX_COLUMNS;
	
	protected Cell[][] board;
	
	public abstract boolean isValid();
	
	protected static Cell[][] gridToBoard(int[][] grid) {
		Cell[][] board = new Cell[BasicBoard.NUM_ROWS][BasicBoard.NUM_COLUMNS];
		
		for (int row = 0; row < BasicBoard.NUM_ROWS; row++) {
			for (int column = 0; column < BasicBoard.NUM_COLUMNS; column++) {
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
	
	public static boolean gridIsProperSize(int[][] grid) {
		if (grid.length != NUM_COLUMNS) return false;
		for (int row = 0; row < Board.NUM_ROWS; row++) {
			if (grid[row].length != NUM_ROWS) return false;
		}
		
		return true;
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
