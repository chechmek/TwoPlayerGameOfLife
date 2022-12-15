package main.Abstract;

import main.UILogic.UI;

public interface Displayable {
    void addUI(UI userInterface);
    void removeUI(UI userInterface);
    void render();
}
