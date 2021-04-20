import java.util.Arrays;

public class Board {
	
	int[][] grid = { { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
	         		 { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
	         		 { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
	         		 { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
	         		 { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
	         		 { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
	         		 { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
	         		 { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
	         		 { 0, 0, 0, 0, 0, 0, 0, 0, 0 } };
	
	public Board() {
		
	}
	
	public void generateRandomBoard() {
		
	}
	
	public String toString() {
		
		String s = "";
		for (int[] array : grid) {
			s += Arrays.toString(array) + "\n";
		}
		
		return s;
	}
}
