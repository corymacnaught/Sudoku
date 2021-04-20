import java.util.Arrays;
import java.util.HashMap;

public class Board {
	
	public final static int NUM_ROWS = 9;
	public final static int NUM_COLUMNS = 9;
	
	//first number = rows, second number = columns
	/*private int[][] grid = { { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
	         		 { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
	         		 { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
	         		 { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
	         		 { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
	         		 { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
	         		 { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
	         		 { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
	         		 { 0, 0, 0, 0, 0, 0, 0, 0, 0 } };*/
	
	private int[][] grid = { {3, 0, 6, 5, 0, 8, 4, 0, 0}, 
	         				 {5, 2, 0, 0, 0, 0, 0, 0, 0}, 
	         				 {0, 8, 7, 0, 0, 0, 0, 3, 1}, 
	         				 {0, 0, 3, 0, 1, 0, 0, 8, 0}, 
	         				 {9, 0, 0, 8, 6, 3, 0, 0, 5}, 
	         				 {0, 5, 0, 0, 9, 0, 6, 0, 0}, 
	         				 {1, 3, 0, 0, 0, 0, 2, 5, 0}, 
	         				 {0, 0, 0, 0, 0, 0, 0, 7, 4}, 
	         				 {0, 0, 5, 2, 0, 6, 3, 0, 0} };
	
	
	
	public Board() {
		
	}
	
	// Generates a board with one solution
	public void generateRandomBoard() {
		
	}
	
	// Solve the current board
	public void solve() {
		
	}
	
	// Check if the current Sudoku is Valid
	public boolean isValid() {
		HashMap<Integer, Integer>[] rows = new HashMap[9];
		HashMap<Integer, Integer>[] columns = new HashMap[9];
		HashMap<Integer, Integer>[] boxes = new HashMap[9];
		
		for (int i = 0; i < rows.length; i++) {
			rows[i] = new HashMap<Integer, Integer>();
			columns[i] = new HashMap<Integer, Integer>();
			boxes[i] = new HashMap<Integer, Integer>();
		}
		
		
		for (int row = 0; row < Board.NUM_ROWS; row++) {
			for (int column = 0; column < Board.NUM_COLUMNS; column++) {
				
				int value = grid[row][column];
				if (value == 0) break;
				
				int box = this.getBox();
				HashMap<Integer, Integer> rowMap = rows[row];
				HashMap<Integer, Integer> columnMap = columns[column];
				HashMap<Integer, Integer> boxMap = boxes[box];
				
				// Check if the value is already in the current row, column or box
				// If if is, return false
				// Otherwise, put the value in the row, column and box
				if (rowMap.containsKey(value) || columnMap.containsKey(value) || boxMap.containsKey(value)) {
					return false;
				} else {
					rowMap.put(value, 1);
					columnMap.put(value, 1);
					boxMap.put(value, 1);
				}
			}
		}
		
		return true;
	}
	
	// Get the box that the row/column is in
	//{1,2,3}
	//{4,5,6}
	//{7,8,9}
	public int getBox() {
		return 0;
	}
	
	public String toString() {
		
		String s = "";
		for (int[] array : grid) {
			s += Arrays.toString(array) + "\n";
		}
		
		return s;
	}
}
