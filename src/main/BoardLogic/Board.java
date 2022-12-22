package main.BoardLogic;

import main.Abstract.Displayable;
import main.CellLogic.AliveCellState;
import main.CellLogic.Cell;
import main.CellLogic.CellMark;
import main.CellLogic.DeadCellState;
import main.Models.Coordinate;
import main.Models.Player;
import main.Static.Input;
import main.UILogic.UI;

import java.util.*;

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
        Cell[][] nextGenMap = new Cell[width][height];

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
    public void killCellOn(int i, int j, CellMark attackingPlayerMark) throws Exception {
        if(map[j][i].state.getMark() == attackingPlayerMark)
            throw new Exception("You can not kill own cells");
        if(map[j][i].state.getMark() == CellMark.Empty)
            throw new Exception("You can not kill dead cells");

        map[j][i].state = new DeadCellState();
    }

    public void aliveCell(int i, int j, CellMark playerMark) throws Exception {
        if(playerMark == CellMark.Empty)
            throw new Exception("Got wrong mark");

        if(map[j][i].state.isAlive())
            throw new Exception("Cell is already alive");

        map[j][i].state = new AliveCellState(playerMark);
    }

    private void initMap(int width, int height){
        map = new Cell[width][height];
        for(int i = 0; i < map.length; i++)
            for(int j = 0; j < map[i].length; j++)
                map[i][j] = new Cell(new DeadCellState());
    }

    public void setUp(){
        //Cell[][] newMap = new Cell[height][width];
        for(int i = 0; i < map.length; i++)
            for(int j = 0; j < map[i].length; j++)
                map[i][j] = new Cell(new DeadCellState());

        Scanner input = new Scanner(System.in);

        Player inputPlayer = new Player(CellMark.PlayerOne);
        inputPlayer.name = "INPUT";
        inputPlayer.symbol = "";

        render(inputPlayer);

        System.out.println("Set up your initial board");
        System.out.println("Type coordinate of cells you want to put in upper part of map, it will be mirrored than horizontally");

        boolean set = false;
        while (!set){
            try{
                while (!set){
                    System.out.println("Type coordinates(e. g. 11, 14) or \"stop\" to finish the map");
                    String inputStr = input.nextLine();
                    if(inputStr.equals("stop"))
                        break;
                    Coordinate coordinate = Input.getCoordinateFromStr(inputStr, this);
                    map[coordinate.y][coordinate.x] = new Cell(new AliveCellState(CellMark.PlayerOne));
                    render(inputPlayer);
                }

                map = helper.mirrorMapHorizontally(map);

                render(inputPlayer);
                System.out.println("This is your initial map");
                set = true;
            }
            catch (Exception ex){
                System.out.println(ex.getMessage());
                System.out.println("Try again");
            }
        }
    }

    public CellMark getMarkOfWinningPlayer(){
        Set<CellMark> playersLeft = new HashSet<>();

        for(int i = 0; i < map.length; i++)
            for(int j = 0; j < map[i].length; j++)
                if(map[i][j].state.isAlive())
                    playersLeft.add(map[i][j].state.getMark());

        if(playersLeft.size() == 0)
            return null;
        if(playersLeft.size() == 1){
            return playersLeft.iterator().next();
        }
        else
            return null;
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
    public void render(Player player) {
        for(UI ui : userInterfaces)
            ui.update(map, generationCount, player);
    }
}
