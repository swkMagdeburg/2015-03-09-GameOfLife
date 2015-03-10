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
	
//	private static final String DIRECTORY = "D:\\work_codingDojos\\gameOfLife2D_finite\\res\\";
	private static final String DIRECTORY = "D:\\GitHub\\2015-03-09-GameOfLife\\gameOfLife2D_finite\\res\\";
	private static final String RESULT_FILE_NAME = "result.txt";
	private static final Charset CHARSET = Charset.defaultCharset();

    public void runGameFromFile(String setUpFileName, int generations) throws Exception {
        final List<String> gameSetUp = readLines(setUpFileName);
		Game game = new Game(gameSetUp);
        
        for (int i = 0; i < generations; i++) {
        	game.getNextGeneration(getResultFile());
		}
    }

	private File getResultFile() {
		return getFile(RESULT_FILE_NAME);
	}

	private File getFile(String filename) {
		return new File(DIRECTORY + filename);
	}

	List<String> readResultingLines() throws Exception {
		return readLines(RESULT_FILE_NAME);
	}

	List<String> readLines(String filename) throws Exception {
		return Files.readLines(getFile(filename), CHARSET);
	}
}
