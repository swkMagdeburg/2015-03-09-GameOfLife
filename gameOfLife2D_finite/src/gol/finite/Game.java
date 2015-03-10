package gol.finite;

import java.io.File;
import java.util.List;

/**
 * @author Katharina Laube, Nico Mertens
 * @since 09.03.2015
 */
public class Game {
	
	private Board board;

	public Game(int xSize, int ySize) {
		board = new Board(xSize, ySize);
	}

	public Game(List<String> gameSetUp) throws Exception {
		this(gameSetUp.get(0).length(), gameSetUp.size());
		
		for (int y = 0; y < gameSetUp.size(); y++) {
			final String line = gameSetUp.get(y);
			addLivingCells(line, y);
		}
	}

	/**
	 * Adds all living cells of the current line to the game
	 */
	private void addLivingCells(String line, int y) throws Exception {
		char[] cells = line.toCharArray();
		for (int x = 0; x < cells.length; x++) {
			
			char cell = cells[x];
			switch (cell) {
			case '.': continue;
			case '*': board.addLivingCell(x, y); continue;
			default:
				throw new IllegalArgumentException("Unknown cell type [" + cell + "]");
			}
			
		}
	}

	public void getNextGeneration(File resultFile) throws Exception {

		Board nextBoard = new Board(board);
		
		for (int x = 0; x < nextBoard.getXSize(); x++) {
			for (int y = 0; y < nextBoard.getYSize(); y++) {
				int neighbours = board.getLivingNeighbours(x, y);
//				if (neighbours <= 1 || neighbours > 3) {
//					nextBoard[x][y] = false;
//				}
//				else 
					if (neighbours == 3) {
					nextBoard.addLivingCell(x, y);
				}
				else if (neighbours == 2 && board.isLivingCell(x, y)) {
					nextBoard.addLivingCell(x, y);
				}
			}
		}
		board = nextBoard;
		board.print(resultFile);
	}

	Board getBoard() {
		return board;
	}

}
