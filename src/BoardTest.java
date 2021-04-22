import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BoardTest {

	@Test
	void test() {
		
	}
	
	@Test
	void getBoxTest() {
		int[][] grid = { {3, 0, 6, 5, 0, 8, 4, 0, 0}, 
				 {5, 2, 0, 0, 0, 0, 0, 0, 0}, 
				 {0, 8, 7, 0, 0, 0, 0, 3, 1}, 
				 {0, 0, 3, 0, 1, 0, 0, 8, 0}, 
				 {9, 0, 0, 8, 6, 3, 0, 0, 5}, 
				 {0, 5, 0, 0, 9, 0, 6, 0, 0}, 
				 {1, 3, 0, 0, 0, 0, 2, 5, 0}, 
				 {0, 0, 0, 0, 0, 0, 0, 7, 4}, 
				 {0, 0, 5, 2, 0, 6, 3, 0, 0} };
		
		Board board = new Board(grid);
		
		assertEquals(0, board.getBox(0, 0));
		assertEquals(0, board.getBox(2, 2));
		assertEquals(1, board.getBox(0, 3));
		assertEquals(1, board.getBox(2, 5));
		assertEquals(2, board.getBox(0, 6));
		assertEquals(2, board.getBox(2, 8));
		assertEquals(3, board.getBox(3, 0));
		assertEquals(3, board.getBox(5, 2));
		assertEquals(4, board.getBox(3, 3));
		assertEquals(4, board.getBox(5, 5));
		assertEquals(5, board.getBox(3, 6));
		assertEquals(5, board.getBox(5, 8));
		assertEquals(6, board.getBox(6, 0));
		assertEquals(6, board.getBox(8, 2));
		assertEquals(7, board.getBox(6, 3));
		assertEquals(7, board.getBox(8, 5));
		assertEquals(8, board.getBox(6, 6));
		assertEquals(8, board.getBox(8, 8));
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

		
		Board boardValid = new Board(gridValid);
		Board boardFailureRow = new Board(gridFailureRow);
		Board boardFailureColumn = new Board(gridFailureColumn);
		Board boardFailureBox = new Board(gridFailureBox);
		Board boardFailureRowLengthLarge = new Board(gridFailureRowLengthLarge);
		Board boardFailureColumnLengthLarge = new Board(gridFailureColumnLengthLarge);
		Board boardFailureRowLengthSmall = new Board(gridFailureRowLengthSmall);
		Board boardFailureColumnLengthSmall = new Board(gridFailureColumnLengthSmall);
		
		assertEquals(true, boardValid.isValid());
		assertEquals(false, boardFailureRow.isValid());
		assertEquals(false, boardFailureColumn.isValid());
		assertEquals(false, boardFailureBox.isValid());
		assertEquals(false, boardFailureRowLengthLarge.isValid());	// These tests are not working correctly
		assertEquals(false, boardFailureColumnLengthLarge.isValid());
		assertEquals(false, boardFailureRowLengthSmall.isValid());	// These tests are not working correctly
		assertEquals(false, boardFailureColumnLengthSmall.isValid());
	}
	
}
