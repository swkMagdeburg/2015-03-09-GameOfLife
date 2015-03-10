package gol.finite;

import java.io.File;

import com.google.common.io.Files;

public class Board {
	
	private boolean board [][];
	
	private int xSize;
	private int ySize;
	
	public Board(int xSize, int ySize) {
		this.xSize = xSize;
		this.ySize = ySize;
		
		board = new boolean[xSize][ySize];
	}

	public Board(Board oldBoard) {
		this(oldBoard.getXSize(), oldBoard.getYSize());
	}

	int getXSize() {
		return xSize;
	}

	int getYSize() {
		return ySize;
	}

	void addLivingCell(int x, int y) {
		board[x][y] = true;
	}

	boolean isLivingCell(int x, int y) {
		return board[x][y];
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

	void print(File file) throws Exception {
		if (file != null) {
			writeToFile(file);
		} else {
			printBoard();
		}
	}

	private void writeToFile(File resultFile) throws Exception {
		StringBuffer sb = new StringBuffer();
		for (int y = 0; y < getYSize(); y++) {
        	for (int x = 0; x < getXSize(); x++) {
        		sb.append(isLivingCell(x, y)? "*" : ".");
        	}
        	sb.append("\n");
        }
		Files.write(sb.toString().getBytes(), resultFile);
	}

	private void printBoard() {
		for (int y = 0; y < getYSize(); y++) {
        	for (int x = 0; x < getXSize(); x++) {
        		System.out.print(isLivingCell(x, y)? "*" : ".");
        	}
        	System.out.println();
        }
    	System.out.println();
	}

}
