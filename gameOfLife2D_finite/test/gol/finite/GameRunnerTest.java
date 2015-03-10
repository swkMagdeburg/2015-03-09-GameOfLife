package gol.finite;

import static org.junit.Assert.assertEquals;

import java.util.List;

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
	public void test4x8() throws Exception {
		System.out.println("\n test4x8");
		classUnderTest.runGameFromFile("game4x8_setUp.txt", 1);
		
		List<String> expected = classUnderTest.readLines("game4x8_2ndGen.txt");
		List<String> result = classUnderTest.readResultingLines();
		
		assertEquals(expected, result);
	}
	
	@Test
	public void testFirstLineDead() throws Exception {
		System.out.println("\n testFirstLineDead");
		classUnderTest.runGameFromFile("gameFirstLineDead_setUp.txt", 1);
		
		List<String> expected = classUnderTest.readLines("gameFirstLineDead_2ndGen.txt");
		List<String> result = classUnderTest.readResultingLines();
		
		assertEquals(expected, result);
	}

}
