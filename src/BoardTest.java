import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BoardTest {

	@Test
	void test() {
		Board board = new Board();
		
		assertEquals(8, board.getBox(8, 8));
		assertEquals(7, board.getBox(6, 5));
		assertEquals(3, board.getBox(3, 2));
		assertEquals(1, board.getBox(1, 5));
	}

}
