package main.BoardLogic;

import main.Abstract.Displayable;
import main.CellLogic.AliveCellState;
import main.CellLogic.Cell;
import main.CellLogic.CellMark;
import main.CellLogic.DeadCellState;
import main.UILogic.UI;

import java.util.ArrayList;
import java.util.List;

public class Board implements Displayable {
    public int width;
    public int height;
    private Cell[][] map;
    private final List<UI> userInterfaces = new ArrayList<>();
    private int generationCount;
    private final BoardHelper helper = new BoardHelper();
    public Board(int w, int h){
        if(w % 2 != 0)
            w++;
        if(h % 2 != 0)
            h++;
        this.width = h;
        this.height = w;
        initMap(width, height);
        generationCount = 0;
    }

    public Cell[][] nextGeneration(){
        Cell[][] nextGenMap = new Cell[height][width];

        for(int i = 0; i < map.length; i++)
            for(int j = 0; j < map[i].length; j++){
                List<Cell> neighbours = helper.getNeighbours(i, j, map);
                var newState = map[i][j].state.getNewState(neighbours);
                nextGenMap[i][j] = new Cell(newState);
            }
        map = nextGenMap;
        generationCount++;
        return map;
    }

    //for players
    //killCell(x, y)
    public void killCellOn(int i, int j){
        map[j][i].state = new DeadCellState();
    }

    public void aliveCell(int i, int j, CellMark playerMark) throws Exception {
        if(playerMark == CellMark.Empty)
            throw new Exception("Got wrong mark");

        map[j][i].state = new AliveCellState(playerMark);
    }

    private void initMap(int width, int height){
        map = new Cell[width][height];
        for(int i = 0; i < map.length; i++)
            for(int j = 0; j < map[i].length; j++)
                map[i][j] = new Cell(new DeadCellState());
    }

    public void setUp(){
        Cell[][] newMap = new Cell[height][width];
        for(int i = 0; i < newMap.length; i++)
            for(int j = 0; j < newMap[i].length; j++)
                newMap[i][j] = new Cell(new DeadCellState());

        boolean set = false;
        while (!set){
            try{
                newMap[4][5] = new Cell(new AliveCellState(CellMark.PlayerOne));
                newMap[4][6] = new Cell(new AliveCellState(CellMark.PlayerOne));
                newMap[4][7] = new Cell(new AliveCellState(CellMark.PlayerTwo));
                newMap[5][5] = new Cell(new AliveCellState(CellMark.PlayerOne));
                newMap[6][6] = new Cell(new AliveCellState(CellMark.PlayerOne));

                newMap = helper.mirrorMapHorizontally(newMap);

                map = newMap;
                set = true;
            }
            catch (Exception ex){
                System.out.println(ex.getMessage());
                System.out.println("Try again");
            }
        }



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
