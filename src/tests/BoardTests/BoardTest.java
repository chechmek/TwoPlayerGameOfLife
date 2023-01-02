package tests.BoardTests;

import main.BoardLogic.Board;
import main.CellLogic.AliveCellState;
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
                if (array1[i][j].getState().getMark() != array2[i][j].getState().getMark()) {
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
        try {
            board.aliveCell(5,5,CellMark.PlayerOne);
            board.aliveCell(5,6,CellMark.PlayerOne);
            board.aliveCell(5,7,CellMark.PlayerOne);
            board.aliveCell(6,5,CellMark.PlayerOne);
            board.aliveCell(6,6,CellMark.PlayerOne);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        try {
            board1.aliveCell(5,5,CellMark.PlayerOne);
            board1.aliveCell(5,6,CellMark.PlayerOne);
            board1.aliveCell(5,7,CellMark.PlayerOne);
            board1.aliveCell(6,5,CellMark.PlayerOne);
            board1.aliveCell(6,6,CellMark.PlayerOne);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        assertTrue(arraysEqual(board.getMap(), board1.getMap()));
        board.nextGeneration();
        assertFalse(arraysEqual(board.getMap(), board1.getMap()));
        board.nextGeneration();
        board.nextGeneration();
        board1.nextGeneration();
        board1.nextGeneration();
        board1.nextGeneration();
        assertTrue(arraysEqual(board.getMap(), board1.getMap()));
        board.nextGeneration();
        board.nextGeneration();
        assertFalse(arraysEqual(board.getMap(), board1.getMap()));

    }

    @Test
    void getMarkOfWinningPlayer() throws Exception {
        Board board = new Board(10,10);
        board.setUp(Boolean.TRUE);
        board.getMap()[3][3].setState(new AliveCellState(CellMark.PlayerOne));
        board.getMap()[3][4].setState(new AliveCellState(CellMark.PlayerOne));
        board.getMap()[3][5].setState(new AliveCellState(CellMark.PlayerOne));
        board.getMarkOfWinningPlayer();
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
        assertEquals(board.getMap()[7][7].getState().getMark(),CellMark.PlayerOne);
    }

    @Test
    void setUp() {
        Board board = new Board(8,8);
        Board board1 = new Board(8,8);
        board.setUp(Boolean.TRUE);
        board1.setUp(Boolean.TRUE);
        assertTrue(arraysEqual(board.getMap(), board1.getMap()));
    }
    @Test
    void BoardConstructor(){
        Board board = new Board(17,17);
        Assertions.assertEquals(18, board.getHeight());
        Assertions.assertEquals(18, board.getWidth());
        board.setHeight(16);
        board.setWidth(16);
        Assertions.assertEquals(16, board.getHeight());
        Assertions.assertEquals(16, board.getWidth());
    }
}