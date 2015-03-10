package gol.finite;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Katharina Laube
 * @since 10.03.2015
 */
public class BoardTest {

	private Board underTest;

	@Before
	public void setUp() throws Exception {
		underTest = new Board(3,3);
	}

	@Test
	public void testBoardSize() {
		underTest = new Board(4,8);
		assertEquals("Wrong numbers of horizontal fields.", 4, underTest.getXSize());
		assertEquals("Wrong numbers of vertical fields.", 8, underTest.getYSize());
		for (int y = 0; y < underTest.getYSize(); y++) {
			for (int x = 0; x < underTest.getXSize(); x++) {
				assertEquals("Cell should be test", false, underTest.isLivingCell(x,y));				
			}			
		}
	}

	@Test
	public void testAddLivingCell()	{
		underTest.addLivingCell(1,1);
		assertEquals("Cell should be alive - ", true, underTest.isLivingCell(1,1));
		assertEquals(0, underTest.getLivingNeighbours(1,1));
	}
	
	@Test
	public void cell_on_the_left_should_have_one_neighbour()	{
		underTest.addLivingCell(1,1);
		assertEquals(1, underTest.getLivingNeighbours(0,1));
	}
	
	@Test
	public void cell_on_the_right_should_have_one_neighbour()	{
		underTest.addLivingCell(1,1);
		assertEquals(1, underTest.getLivingNeighbours(2,1));
	}
	
	@Test
	public void cell_on_the_top_should_have_one_neighbour()	{
		underTest.addLivingCell(1,1);
		assertEquals(1, underTest.getLivingNeighbours(1,0));
	}
	
	@Test
	public void cell_on_the_bottom_should_have_one_neighbour()	{
		underTest.addLivingCell(1,1);
		assertEquals(1, underTest.getLivingNeighbours(1,2));
	}
	
	@Test
	public void cell_on_the_upper_left_corner_should_have_one_neighbour()	{
		underTest.addLivingCell(1,1);
		assertEquals(1, underTest.getLivingNeighbours(0,0));
	}
	
	@Test
	public void cell_on_the_upper_right_corner_should_have_one_neighbour()	{
		underTest.addLivingCell(1,1);
		assertEquals(1, underTest.getLivingNeighbours(0,2));
	}
	
	@Test
	public void cell_on_the_downer_left_corner_should_have_one_neighbour()	{
		underTest.addLivingCell(1,1);
		assertEquals(1, underTest.getLivingNeighbours(2,0));
	}
	
	@Test
	public void cell_on_the_downer_right_corner_should_have_one_neighbour()	{
		underTest.addLivingCell(1,1);
		assertEquals(1, underTest.getLivingNeighbours(2,2));
	}
	
	@Test
	public void cell_should_have_three_neighbour()	{
		underTest.addLivingCell(0,0);
		underTest.addLivingCell(1,0);
		underTest.addLivingCell(2,0);
		assertEquals(3, underTest.getLivingNeighbours(1,1));
	}

}
