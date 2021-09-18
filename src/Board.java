import java.util.Arrays;

public abstract class Board {
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
	
	public String toString() {
		String s = "";
		for (Cell[] array : board) s += Arrays.toString(array) + "\n";
		return s;
	}
}
