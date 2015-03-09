package gol;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BoardTest {

    @Test
    public void testBoardInitialization() {
        Board board = new Board(5, 5);
        int fieldCount = board.getFieldCount();

        assertEquals(25, fieldCount);
    }

    @Test
    public void testFieldNeighborCountTopLeft() {
        Board board = new Board(5, 5);
        Field field = board.getFieldAt(0, 0);
        assertEquals(3, field.neighborCount());

    }
}
