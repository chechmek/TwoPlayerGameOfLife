package main.Models;

import main.Abstract.Displayable;
import main.CellLogic.AliveCellState;
import main.CellLogic.Cell;
import main.CellLogic.CellMark;
import main.CellLogic.DeadCellState;
import main.UILogic.UI;

import java.util.ArrayList;
import java.util.List;

public class Board implements Displayable {
    private Cell[][] map;
    private List<UI> userInterfaces = new ArrayList<>();
    private int generationCount;
    public Board(int width, int height){
        initMap(width, height);
        generationCount = 0;
    }

    public void nextGeneration(){
        for(int i = 0; i < map.length; i++)
            for(int j = 0; j < map[i].length; i++){
                List<Cell> neighbours = getNeighbours(i, j);
                map[i][j].Handle(neighbours);
            }
    }

    //for players
    //killCell(x, y)
    public void killCellOn(int i, int j){
        map[i][j].state = new DeadCellState();
    }

    public void aliveCell(int i, int j, CellMark playerMark){
        if(playerMark == CellMark.Empty)
            return;

        map[i][j].state = new AliveCellState(playerMark);
    }

    private List<Cell> getNeighbours(int i, int j){
        return null; // TODO
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
            ui.update(map, generationCount);
    }
}
