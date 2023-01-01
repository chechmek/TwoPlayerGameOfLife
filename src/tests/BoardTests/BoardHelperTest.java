package BoardTests;

import main.BoardLogic.Board;
import main.BoardLogic.BoardHelper;
import main.CellLogic.CellMark;
import main.Models.Pair;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardHelperTest {

    @Test
    void getNeighbours() {
    }

    @Test
    void calculateNumberOfCells() {
        Board board = new Board(8,8);
        try {
            board.aliveCell(7, 7, CellMark.PlayerOne);
            board.aliveCell(6, 7, CellMark.PlayerOne);
            board.aliveCell(5, 7, CellMark.PlayerOne);
            board.aliveCell(7, 5, CellMark.PlayerTwo);
            board.aliveCell(7, 6, CellMark.PlayerTwo);

        }
        catch (Exception exception){
            System.out.println(exception.getMessage());
        }
        BoardHelper boardHelper = new BoardHelper();
        Pair pairA = new Pair(3,2);
        Pair pairB = new Pair(3,2);
        assertEquals(boardHelper.calculateNumberOfCells(board.getMap()).getA(), pairA.getA());
        assertEquals(boardHelper.calculateNumberOfCells(board.getMap()).getB(), pairB.getB());
        Pair pairTest = new Pair(34,2);
        assertNotEquals(boardHelper.calculateNumberOfCells(board.getMap()).getA(), pairTest.getA());
    }
}