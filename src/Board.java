import java.util.Arrays;

public abstract class Board {
	public final static int NUM_ROWS = 9;
	public final static int NUM_COLUMNS = 9;
	
	private final static int SMALL_BOX_ROWS = (int) Math.sqrt(NUM_ROWS);
	private final static int SMALL_BOX_COLUMNS = (int) Math.sqrt(NUM_COLUMNS);
	
	public final static int NUM_BOXES = SMALL_BOX_ROWS * SMALL_BOX_COLUMNS;
	
	protected Cell[][] board;
	
	// Solve the current board
	public void solve() {
		this.solve(0, 0);
	}
	
	protected abstract boolean solve(int row, int column);
	
	public abstract boolean isValid();
	
	public static Cell[][] gridToBoard(int[][] grid) {
		Cell[][] board = new Cell[BasicBoard.NUM_ROWS][BasicBoard.NUM_COLUMNS];
		
		for (int row = 0; row < BasicBoard.NUM_ROWS; row++) {
			for (int column = 0; column < BasicBoard.NUM_COLUMNS; column++) {
				board[row][column] = new Cell(grid[row][column]);
			}
		}
		
		return board;
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
		for (Cell[] array : board) s += Arrays.toString(array) + "\n";
		return s;
	}
}
