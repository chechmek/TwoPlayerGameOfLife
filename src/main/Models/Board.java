package main.Models;

import main.Abstract.Displayable;
import main.CellLogic.Cell;
import main.UILogic.UI;

import java.util.ArrayList;
import java.util.List;

public class Board implements Displayable {
    private Cell[][] map;
    private List<UI> userInterfaces = new ArrayList<>();
    public Board(int width, int height){
        initMap(width, height);
    }

    private void initMap(int width, int height){
        map = new Cell[height][width];
        for(int i = 0; i < map.length; i++)
            for(int j = 0; j < map[i].length; i++)
                map[i][j] = new Cell();
    }

    @Override
    public void addUI(UI userInterface) {
        userInterfaces.add(userInterface);
    }

    @Override
    public void removeUI(UI userInterface) {
        userInterfaces.remove(userInterface);
    }

    @Override
    public void render() {
        for(UI ui : userInterfaces)
            ui.update(map);
    }
}
