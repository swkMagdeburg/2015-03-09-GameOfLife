package gol.finite;

import static org.junit.Assert.assertEquals;

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
		assertEquals("Wrong numbers of horizontal fields.", 3, underTest.getXSize());
		assertEquals("Wrong numbers of vertical fields.", 6, underTest.getYSize());
		for (int y = 0; y < underTest.getYSize(); y++) {
			for (int x = 0; x < underTest.getXSize(); x++) {
				assertEquals("Cell should be test", false, underTest.isLivingCell(x,y));				
			}			
		}
	}

	@Test
	public void testAddLivingCell()	{
		underTest.addLivingCell(2,4);
		assertEquals("Cell should be alive - ", true, underTest.isLivingCell(2,4));
		assertEquals(0, underTest.getLivingNeighbours(2, 4));
	}
	
	@Test
	public void cellShouldHaveOneNeighbour()	{
		underTest.addLivingCell(2,4);
		assertEquals("Cell should be alive - ", true, underTest.isLivingCell(2,4));
		assertEquals(1, underTest.getLivingNeighbours(1, 4));
	}

}
