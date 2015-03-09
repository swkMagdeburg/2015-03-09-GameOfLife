package gol;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FieldTest {

    @Test
    public void testInitialState() {
        Field field = new Field(CellState.DEAD);
        assertEquals(CellState.DEAD, field.getCellState());
    }

    @Test
    public void testKnownNeighbors() {
        Field field = new Field(CellState.DEAD);
        Field neighbor = new Field(CellState.ALIVE);
        field.addNeighbor(neighbor);
        assertEquals(1, field.neighborCount());
    }

    @Test
    public void testDieIfLessThanTwoAliveNeighbors() {
        Field field = new Field(CellState.ALIVE);
        Field deadNeighbor = new Field(CellState.DEAD);
        field.addNeighbor(deadNeighbor);

        field.calcNextState();
        CellState nextCellState = field.getNextState();
        assertEquals(CellState.DEAD, nextCellState);
    }

    @Test
    public void testDyingWithMoreThanThreeAliveNeighbors() {
        Field field = new Field(CellState.ALIVE);
        field.addNeighbor(new Field(CellState.ALIVE));
        field.addNeighbor(new Field(CellState.ALIVE));
        field.addNeighbor(new Field(CellState.ALIVE));
        field.addNeighbor(new Field(CellState.ALIVE));

        field.calcNextState();
        CellState nextCellState = field.getNextState();
        assertEquals(CellState.DEAD, nextCellState);
    }

    @Test
    public void testStayAliveIfTwoAliveNeighbors() {
        Field field = new Field(CellState.ALIVE);
        field.addNeighbor(new Field(CellState.ALIVE));
        field.addNeighbor(new Field(CellState.ALIVE));

        field.calcNextState();
        CellState nextCellState = field.getNextState();
        assertEquals(CellState.ALIVE, nextCellState);
    }

    @Test
    public void testStayDeadIfTwoAliveNeighbors() {
        Field field = new Field(CellState.DEAD);
        field.addNeighbor(new Field(CellState.ALIVE));
        field.addNeighbor(new Field(CellState.ALIVE));

        field.calcNextState();
        CellState nextCellState = field.getNextState();
        assertEquals(CellState.DEAD, nextCellState);
    }

    @Test
    public void testBornWithThreeAliveNeighbors() {
        Field field = new Field(CellState.DEAD);
        field.addNeighbor(new Field(CellState.ALIVE));
        field.addNeighbor(new Field(CellState.ALIVE));
        field.addNeighbor(new Field(CellState.ALIVE));

        field.calcNextState();
        CellState nextCellState = field.getNextState();
        assertEquals(CellState.ALIVE, nextCellState);
    }

}
