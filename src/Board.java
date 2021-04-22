import java.util.Arrays;
import java.util.HashMap;

public class Board {
	
	public final static int NUM_ROWS = 9;
	public final static int NUM_COLUMNS = 9;
	public final static int NUM_BOXES = 9;
	
	//first number = rows, second number = columns
	
	private int[][] grid;
	
	public Board(int[][] grid) {
		this.grid = grid;
	}
	
	// Generates a board with one solution
	public void generateRandomBoard() {
		
	}
	
	// Solve the current board
	public void solve() {
		
	}
	
	// Check if the current Sudoku is Valid
	public boolean isValid() {
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
				
				int box = this.getBox(row, column);
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
	public int getBox(int row, int column) {
		return row / 3 * 3 + column / 3;
	}
	
	public String toString() {
		
		String s = "";
		for (int[] array : grid) {
			s += Arrays.toString(array) + "\n";
		}
		
		return s;
	}
}
