package BoardTests;

import main.BoardLogic.Board;
import main.CellLogic.Cell;
import main.CellLogic.CellMark;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BoardTest {
    public static boolean arraysEqual(Cell[][] array1, Cell[][] array2) {
        if (array1.length != array2.length) {
            return false;
        }
        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array1[i].length; j++) {
                if (array1[i][j].state.getMark() != array2[i][j].state.getMark()) {
                    return false;
                }
            }
        }
        return true;
    }
    @Test
    void nextGeneration() {
        Board board = new Board(20,20);
        Board board1 = new Board(20,20);
        board.setUp();
        board1.setUp();
        assertTrue(arraysEqual(board.map,board1.map));
        board.nextGeneration();
        assertFalse(arraysEqual(board.map,board1.map));
        board.nextGeneration();
        board.nextGeneration();
        board1.nextGeneration();
        board1.nextGeneration();
        board1.nextGeneration();
        assertTrue(arraysEqual(board.map,board1.map));
        board.nextGeneration();
        board.nextGeneration();
        assertFalse(arraysEqual(board.map,board1.map));

    }

    @Test
    void killCellOn() {
    }

    @Test
    void aliveCell() {
        Board board = new Board(8,8);
        try {
            board.aliveCell(7, 7, CellMark.PlayerOne);
        }
        catch (Exception exception){
            exception.printStackTrace();
        }
        assertEquals(board.map[7][7].state.getMark(),CellMark.PlayerOne);
    }

    @Test
    void setUp() {
        Board board = new Board(8,8);
        Board board1 = new Board(8,8);
        board.setUp();
        board1.setUp();
        assertTrue(arraysEqual(board.map,board1.map));
    }
    @Test
    void BoardConstructor(){
        Board board = new Board(17,17);
        Assertions.assertEquals(18,board.height);
        Assertions.assertEquals(18,board.width);
        board.height=16;
        board.width=16;
        Assertions.assertEquals(16,board.height);
        Assertions.assertEquals(16,board.width);
    }
}