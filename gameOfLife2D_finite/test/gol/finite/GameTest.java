package gol.finite;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Katharina Laube, Nico Mertens
 * @since 09.03.2015
 */
public class GameTest {

	private Game underTest;

	@Before
	public void setUp() throws Exception {
		underTest = new Game(3,6);
	}

	@Test
	public void testBoardSize() {
		Board board = underTest.getBoard();
		assertNotNull(board);
		assertEquals("Wrong numbers of horizontal fields.", 3, board.getXSize());
		assertEquals("Wrong numbers of vertical fields.", 6, board.getYSize());
		for (int y = 0; y < board.getYSize(); y++) {
			for (int x = 0; x < board.getXSize(); x++) {
				assertEquals("New cell should be dead", false, board.isLivingCell(x,y));				
			}			
		}
	}

}
