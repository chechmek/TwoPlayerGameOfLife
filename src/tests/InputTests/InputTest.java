package tests.InputTests;

import main.BoardLogic.Board;
import main.Static.Input;
import org.junit.jupiter.api.Test;

class InputTest {

    @Test
    final void positiveScenario() {
        Board board = new Board(10,10);
        String simulatedUserInput = "1, " + "2";
        try {
            Input.getCoordinateFromStr(simulatedUserInput,board);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}