package gol.finite;


import java.io.File;
import java.nio.charset.Charset;
import java.util.List;

import com.google.common.io.Files;

/**
 * @author Katharina Laube
 * @since 09.03.2015
 */
public class GameRunner {
	
	private static final String DIRECTORY = "D:\\work_codingDojos\\gameOfLife2D_finite\\res\\";
	private static final String FILE_NAME = "gameSetUp4x8.txt";
	public static void main(String[] args) throws Exception {
		GameRunner runner = new GameRunner();
		runner.createGameFromFile(FILE_NAME, 5);
	}

    private Game game;
    
    public GameRunner() {
    	game = new Game(8, 4);
	}

    public void createGameFromFile(String fileName, int generations) throws Exception {
        loadGameSetUpFromFile(fileName);
        
        for (int i = 0; i < generations; i++) {
        	game.getNextGeneration();
        	printBoard();
        	System.out.println();
		}
    }

	void printBoard() {
		for (int y = 0; y < 4; y++) {
        	for (int x = 0; x < 8; x++) {
        		System.out.print(game.isLivingCell(x, y)? "*" : ".");
        	}
        	System.out.print("\n");
        }
	}

	private void loadGameSetUpFromFile(String fileName) throws Exception {
        
		final File file = new File(DIRECTORY + fileName);
		final Charset charset = Charset.defaultCharset();
		
		final List<String> gameSetUp = Files.readLines(file, charset);
		
		for (int y = 0; y < gameSetUp.size(); y++) {
			String line = gameSetUp.get(y);
			parseLine(line, y);
		}
	}

	/**
	 * Adds all living cells of the current line to the game
	 */
	void parseLine(String line, int y) throws Exception {
		char[] cells = line.toCharArray();
		for (int x = 0; x < cells.length; x++) {
			
			char cell = cells[x];
			switch (cell) {
			case '.': continue;
			case '*': game.addLivingCell(x, y); continue;
			default:
				throw new IllegalArgumentException("Unknown cell type [" + cell + "]");
			}
			
		}
	}
}
