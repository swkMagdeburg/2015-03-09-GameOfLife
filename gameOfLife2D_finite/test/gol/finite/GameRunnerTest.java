package gol.finite;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Katharina Laube, Nico Mertens
 * @since 09.03.2015
 */
public class GameRunnerTest {

	private GameRunner classUnderTest;

	@Before
	public void setUp() throws Exception {
		classUnderTest = new GameRunner();
	}

	@Test
	public void testExample() throws Exception {
		System.out.println("\n testExample");
		classUnderTest.createGameFromFile("gameSetUp4x8.txt", 5);
	}
	
	@Test
	public void testFirstLineDead() throws Exception {
		System.out.println("\n testFirstLineDead");
		classUnderTest.createGameFromFile("gameSetUp4x8_firstLineDead.txt", 5);
	}

}
