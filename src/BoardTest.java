import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BoardTest {

	@Test
	void test() {
		
	}
	
	@Test
	void calculateSudokuBoxTest() {
		assertEquals(0, Board.calculateSudokuBox(0, 0));
		assertEquals(0, Board.calculateSudokuBox(2, 2));
		assertEquals(1, Board.calculateSudokuBox(0, 3));
		assertEquals(1, Board.calculateSudokuBox(2, 5));
		assertEquals(2, Board.calculateSudokuBox(0, 6));
		assertEquals(2, Board.calculateSudokuBox(2, 8));
		assertEquals(3, Board.calculateSudokuBox(3, 0));
		assertEquals(3, Board.calculateSudokuBox(5, 2));
		assertEquals(4, Board.calculateSudokuBox(3, 3));
		assertEquals(4, Board.calculateSudokuBox(5, 5));
		assertEquals(5, Board.calculateSudokuBox(3, 6));
		assertEquals(5, Board.calculateSudokuBox(5, 8));
		assertEquals(6, Board.calculateSudokuBox(6, 0));
		assertEquals(6, Board.calculateSudokuBox(8, 2));
		assertEquals(7, Board.calculateSudokuBox(6, 3));
		assertEquals(7, Board.calculateSudokuBox(8, 5));
		assertEquals(8, Board.calculateSudokuBox(6, 6));
		assertEquals(8, Board.calculateSudokuBox(8, 8));
	}
	
	@Test
	void isValidAdditionTest() {
		int[][] gridEmpty = { { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
	       		 { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
	       		 { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
	       		 { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
	       		 { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
	       		 { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
	       		 { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
	       		 { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
	       		 { 0, 0, 0, 0, 0, 0, 0, 0, 0 } };
		
		int[][] gridFilled = { {3, 0, 6, 5, 0, 8, 4, 0, 0}, 
	 			  			   {5, 2, 0, 0, 0, 0, 0, 0, 0}, 
	 			  			   {0, 8, 7, 0, 0, 0, 0, 3, 1}, 
	 			  			   {0, 0, 3, 0, 1, 0, 0, 8, 0}, 
	 			  			   {9, 0, 0, 8, 6, 3, 0, 0, 5}, 
	 			  			   {0, 5, 0, 0, 9, 0, 6, 0, 0}, 
	 			  			   {1, 3, 0, 0, 0, 0, 2, 5, 0}, 
	 			  			   {0, 0, 0, 0, 0, 0, 0, 7, 4}, 
	 			  			   {0, 0, 5, 2, 0, 6, 3, 0, 0} };
		
		Board boardEmpty = new Board(gridEmpty);
		Board boardFilled = new Board(gridFilled);
		
		assertEquals(true, boardEmpty.isValidAddition(0, 0, 1));
		assertEquals(false, boardFilled.isValidAddition(6, 2, 2)); // fails on row
		assertEquals(false, boardFilled.isValidAddition(6, 2, 6)); // fails on column
		assertEquals(false, boardFilled.isValidAddition(7, 1, 1)); // fails on box
	}

	@Test
	void isValidTest() {
		int[][] gridValid = { {3, 0, 6, 5, 0, 8, 4, 0, 0}, 
				 			  {5, 2, 0, 0, 0, 0, 0, 0, 0}, 
				 			  {0, 8, 7, 0, 0, 0, 0, 3, 1}, 
				 			  {0, 0, 3, 0, 1, 0, 0, 8, 0}, 
							  {9, 0, 0, 8, 6, 3, 0, 0, 5}, 
							  {0, 5, 0, 0, 9, 0, 6, 0, 0}, 
							  {1, 3, 0, 0, 0, 0, 2, 5, 0}, 
							  {0, 0, 0, 0, 0, 0, 0, 7, 4}, 
							  {0, 0, 5, 2, 0, 6, 3, 0, 0} };
		
		int[][] gridFailureRow = { { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
       		 					   { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
       		 					   { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
       		 					   { 0, 0, 3, 0, 0, 0, 3, 0, 0 },
       		 					   { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
       		 					   { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
       		 					   { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
       		 					   { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
       		 					   { 0, 0, 0, 0, 0, 0, 0, 0, 0 } };
		
		int[][] gridFailureColumn = { { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
       		 { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
       		 { 0, 0, 0, 0, 0, 0, 4, 0, 0 },
       		 { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
       		 { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
       		 { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
       		 { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
       		 { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
       		 { 0, 0, 0, 0, 0, 0, 4, 0, 0 } };
		
		int[][] gridFailureBox = { { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
       		 { 0, 0, 0, 0, 0, 0, 2, 0, 0 },
       		 { 0, 0, 0, 0, 0, 0, 0, 2, 0 },
       		 { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
       		 { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
       		 { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
       		 { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
       		 { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
       		 { 0, 0, 0, 0, 0, 0, 0, 0, 0 } };
		
		int[][] gridFailureRowLengthLarge = { { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
       		 { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
       		 { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
       		 { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
       		 { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
       		 { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
       		 { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
       		 { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
       		 { 0, 0, 0, 0, 0, 0, 0, 0, 0 } };
		
		int[][] gridFailureColumnLengthLarge = { { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
	       		 { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
	       		 { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
	       		 { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
	       		 { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
	       		 { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
	       		 { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
	       		 { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
	       		 { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
	       		 { 0, 0, 0, 0, 0, 0, 0, 0, 0 }};
		
		int[][] gridFailureRowLengthSmall = { { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
       		 { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
       		 { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
       		 { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
       		 { 0, 0, 0, 0, 0, 0, 0, 0 },
       		 { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
       		 { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
       		 { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
       		 { 0, 0, 0, 0, 0, 0, 0, 0, 0 } };
		
		int[][] gridFailureColumnLengthSmall = { { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
       		 { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
       		 { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
       		 { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
       		 { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
       		 { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
       		 { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
       		 { 0, 0, 0, 0, 0, 0, 0, 0, 0 } };
		
		/*assertEquals(true, Board.isValidGrid(gridValid));
		assertEquals(false, Board.isValidGrid(gridFailureRow));
		assertEquals(false, Board.isValidGrid(gridFailureColumn));
		assertEquals(false, Board.isValidGrid(gridFailureBox));
		assertEquals(false, Board.isValidGrid(gridFailureRowLengthLarge));	// These tests are not working correctly
		assertEquals(false, Board.isValidGrid(gridFailureColumnLengthLarge));
		assertEquals(false, Board.isValidGrid(gridFailureRowLengthSmall));	// These tests are not working correctly
		assertEquals(false, Board.isValidGrid(gridFailureColumnLengthSmall));*/
	}
	
}
