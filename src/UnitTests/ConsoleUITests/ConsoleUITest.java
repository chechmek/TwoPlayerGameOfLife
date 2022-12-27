package ConsoleUITests;

import main.BoardLogic.Board;
import main.CellLogic.CellMark;
import main.Models.Player;
import main.UILogic.ConsoleUI;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConsoleUITest {

    @Test
    void setSymbols() {
        List<Player> players = new ArrayList<>();
        ConsoleUI cui = new ConsoleUI();
        players.add(new Player(CellMark.PlayerOne));
        players.add(new Player(CellMark.PlayerTwo));
        players.get(0).symbol="A";
        players.get(1).symbol="B";
        cui.setSymbols(players.get(0).symbol, players.get(1).symbol);
        assertEquals("A",players.get(0).symbol);
        assertEquals("B",players.get(1).symbol);
    }

    @Test
    void update() {
        ConsoleUI consoleUI = new ConsoleUI();
        Board board = new Board(10,10);
        consoleUI.update(board.map, 0);

    }
}