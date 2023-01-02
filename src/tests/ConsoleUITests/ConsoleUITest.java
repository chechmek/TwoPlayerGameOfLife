package tests.ConsoleUITests;

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
        players.get(0).setSymbol("A");
        players.get(1).setSymbol("B");
        cui.setSymbols(players.get(0).getSymbol(), players.get(1).getSymbol());
        assertEquals("A", players.get(0).getSymbol());
        assertEquals("B", players.get(1).getSymbol());
    }
}