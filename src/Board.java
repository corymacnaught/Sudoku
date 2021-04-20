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
		
		for (int row = 0; row < Board.NUM_ROWS; row++) {
			for (int column = 0; column < Board.NUM_COLUMNS; column++) {
				
			}
		}
		
		return false;
	}
	
	public String toString() {
		
		String s = "";
		for (int[] array : grid) {
			s += Arrays.toString(array) + "\n";
		}
		
		return s;
	}
}
