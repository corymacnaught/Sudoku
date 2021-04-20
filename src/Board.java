import java.util.Arrays;

public class Board {
	
	/*int[][] grid = { { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
	         		 { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
	         		 { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
	         		 { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
	         		 { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
	         		 { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
	         		 { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
	         		 { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
	         		 { 0, 0, 0, 0, 0, 0, 0, 0, 0 } };*/
	
	int[][] grid = { {3, 0, 6, 5, 0, 8, 4, 0, 0}, 
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
	public void isValid() {
		
	}
	
	public String toString() {
		
		String s = "";
		for (int[] array : grid) {
			s += Arrays.toString(array) + "\n";
		}
		
		return s;
	}
}
