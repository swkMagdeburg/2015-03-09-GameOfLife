package gol;

import java.util.ArrayList;

public class Field {

    private CellState cellState;
    private CellState nextCellState;
    private final ArrayList<Field> neighbors = new ArrayList<Field>();

    public Field(CellState cellState) {

        this.cellState = cellState;
    }

    public CellState getCellState() {
        return cellState;
    }

    public void addNeighbor(Field neighbor) {
        neighbors.add(neighbor);
    }

    public int neighborCount() {
        return neighbors.size();
    }

    public CellState getNextState() {
        return nextCellState;
    }

    public void switchIteration() {
        this.cellState = this.nextCellState;
        this.nextCellState = null;
    }

    public void calcNextState() {
        int aliveCount = getAliveNeighborCount();
        if (this.getCellState() == CellState.ALIVE) {
            if (aliveCount < 2 || aliveCount > 3) {
                nextCellState = CellState.DEAD;
            } else {
                nextCellState = CellState.ALIVE;
            }
        } else {
            if (aliveCount == 3) {
                nextCellState = CellState.ALIVE;
            } else {
                nextCellState = CellState.DEAD;
            }
        }
    }

    private int getAliveNeighborCount() {
        int aliveCount = 0;
        for (Field neighbor : this.neighbors) {
            if (neighbor.getCellState() == CellState.ALIVE) {
                aliveCount++;
            }
        }
        return aliveCount;
    }
}
