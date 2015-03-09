package gol.finite;

/**
 * @author Katharina Laube, Nico Mertens
 * @since 09.03.2015
 */
public class Game {
	
	private boolean board [][];
	
	private int xSize;
	private int ySize;

	public Game(int xSize, int ySize) {
		this.xSize = xSize;
		this.ySize = ySize;
		
		board = new boolean[xSize][ySize];
	}

	public int getXSize() {
		return xSize;
	}

	public int getYSize() {
		return ySize;
	}

	public void addLivingCell(int x, int y) {
		board[x][y] = true;
	}

	public boolean isLivingCell(int x, int y) {
		return board[x][y];
	}

	public void getNextGeneration() {

		boolean[][] nextBoard = new boolean[xSize][ySize];
		
		for (int x = 0; x < xSize; x++) {
			for (int y = 0; y < ySize; y++) {
				int neighbours = getLivingNeighbours(x, y);
				if (neighbours <= 1 || neighbours > 3) {
					nextBoard[x][y] = false;
				}
				else if (neighbours == 3) {
					nextBoard[x][y] = true;
				}
				else if (neighbours == 2 && isLivingCell(x, y)) {
					nextBoard[x][y] = true;					
				}
			}
		}
		board = nextBoard;
	}

	int getLivingNeighbours(int x, int y) {
		int count = 0;
		
		int minX = x == 0 ? 0 : x-1;
		int maxX = x == xSize-1 ? x : x+1;
		
		int minY = y == 0 ? 0 : y-1;
		int maxY = y == ySize-1 ? y : y+1;
		
		for (int i = minX; i <= maxX; i++) {
			for (int j = minY; j <= maxY; j++) {
				if(i==x && j==y) {
					continue;
				}
				if(isLivingCell(i, j)) {
					count++;
				}
			}
		}
		return count;
	}

}
