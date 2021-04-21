import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BoardTest {

	@Test
	void test() {
		getBoxTest();
		
	}
	
	void getBoxTest() {
		Board board = new Board();
		
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

}
