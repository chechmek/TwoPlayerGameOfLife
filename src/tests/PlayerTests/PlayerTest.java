package tests.PlayerTests;

import main.BoardLogic.Board;
import main.CellLogic.CellMark;
import main.Models.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PlayerTest {

    @Test
    void play() {
        Player player = new Player(CellMark.PlayerOne);
        Board board = new Board(10,10);
        board.initMap(10,10);
        try {
            board.aliveCell(1,2,CellMark.PlayerTwo);
            board.aliveCell(1,3,CellMark.PlayerTwo);
            board.aliveCell(1,4,CellMark.PlayerTwo);
            board.aliveCell(1,5,CellMark.PlayerTwo);
            board.aliveCell(1,6,CellMark.PlayerOne);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Assertions.assertEquals(player.getPlayerMark(), CellMark.PlayerOne);
    }
}