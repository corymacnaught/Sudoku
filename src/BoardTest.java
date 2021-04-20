import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BoardTest {

	@Test
	void test() {
		Board board = new Board();
		
		assertEquals(true, board.isValid());
	}

}
