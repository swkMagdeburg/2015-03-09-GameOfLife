package gol;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private final List<Field> fieldList = new ArrayList<Field>();
    private final int colCount, rowCount;

    public Board(int cols, int rows) {
        colCount = cols;
        rowCount = rows;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                Field field = new Field(c == 0 ? CellState.ALIVE : CellState.DEAD);
                fieldList.add(field);

                addNeighborIfExists(c - 1, r - 1, field);
                addNeighborIfExists(c, r - 1, field);
                addNeighborIfExists(c + 1, r - 1, field);
                addNeighborIfExists(c - 1, r, field);
                addNeighborIfExists(c + 1, r, field);
                addNeighborIfExists(c - 1, r + 1, field);
                addNeighborIfExists(c, r + 1, field);
                addNeighborIfExists(c + 1, r + 1, field);
            }
        }
    }

    public void calculateNextIteration() {
        for (Field field : fieldList) {
            field.calcNextState();
        }
        for (Field field : fieldList) {
            field.switchIteration();
        }
    }

    public void print() {
        for(int c = 0; c < colCount; c++){
            for (int r = 0; r < rowCount; r++) {
                System.out.print(getFieldAt(c, r).getCellState() == CellState.ALIVE ? "*" : ".");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Board board = new Board(5, 5);
        board.print();
        System.out.println("");
        while (board.atLeastOneAlive()) {
            board.calculateNextIteration();
            board.print();
            System.out.println("");
        }
    }

    public boolean atLeastOneAlive() {
        for (Field field : fieldList) {
            if (field.getCellState() == CellState.ALIVE) {
                return true;
            }
        }
        return false;
    }

    private void addNeighborIfExists(int c, int r, Field field) {
        Field fieldNeigbor = getFieldAt(c, r);
        if (fieldNeigbor != null) {
            field.addNeighbor(fieldNeigbor);
            fieldNeigbor.addNeighbor(field);
        }
    }

    public int getFieldCount() {
        return fieldList.size();
    }

    public Field getFieldAt(int col, int row) {
        if (col < 0 || row < 0 || col >= colCount || row >= rowCount)
            return null;

        int index = colCount * row + col;
        if (index < 0 || index >= fieldList.size()) {
            return null;
        }
        return fieldList.get(index);
    }
}
