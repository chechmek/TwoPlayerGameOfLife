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
    private int width;
    private int height;
    private Cell[][] map;
    private final List<UI> userInterfaces = new ArrayList<>();
    private int generationCount;
    private final BoardHelper helper = new BoardHelper();
    public Board(int w, int h){
        if(w % 2 != 0)
            w++;
        if(h % 2 != 0)
            h++;
        this.setWidth(h);
        this.setHeight(w);
        initMap(getWidth(), getHeight());
        generationCount = 0;
    }


    public void  nextGeneration(){
        Cell[][] nextGenMap = new Cell[getHeight()][getWidth()];

        for(int i = 0; i < getMap().length; i++)
            for(int j = 0; j < getMap()[i].length; j++){
                List<Cell> neighbours = helper.getNeighbours(i, j, getMap());
                var newState = getMap()[i][j].getState().getNewState(neighbours);
                nextGenMap[i][j] = new Cell(newState);
            }
        setMap(nextGenMap);
        generationCount++;

    }

    //for players
    //killCell(x, y)
    public void killCellOn(int i, int j, CellMark attackingPlayerMark) throws Exception {
        if(getMap()[j][i].getState().getMark() == attackingPlayerMark)
            throw new Exception("You can not kill own cells");
        if(getMap()[j][i].getState().getMark() == CellMark.Empty)
            throw new Exception("You can not kill dead cells");

        getMap()[j][i].setState(new DeadCellState());
    }

    public void aliveCell(int i, int j, CellMark playerMark) throws Exception {
        if(playerMark == CellMark.Empty)
            throw new Exception("Got wrong mark");

        if(getMap()[j][i].getState().isAlive())
            throw new Exception("Cell is already alive");

        getMap()[j][i].setState(new AliveCellState(playerMark));
    }

    public void initMap(int width, int height){
        setMap(new Cell[width][height]);
        for(int i = 0; i < getMap().length; i++)
            for(int j = 0; j < getMap()[i].length; j++)
                getMap()[i][j] = new Cell(new DeadCellState());
    }

    public void setUp(Boolean checker){
        //Cell[][] newMap = new Cell[height][width];
        for(int i = 0; i < getMap().length; i++)
            for(int j = 0; j < getMap()[i].length; j++)
                getMap()[i][j] = new Cell(new DeadCellState());

        Scanner input = new Scanner(System.in);
        Player inputPlayer = new Player(CellMark.PlayerOne);
        inputPlayer.setName("INPUT");
        inputPlayer.setSymbol("");

        render(inputPlayer);

        System.out.println("Set up your initial board");
        System.out.println("Type coordinate of cells you want to put in upper part of map, it will be mirrored than horizontally");

        boolean set = false;
        while (!set){
            try{
                while (!set){
                    if(checker){
                        break;
                    }
                    System.out.println("Type coordinates(e. g. 11, 14) or \"stop\" to finish the map");
                    String inputStr = input.nextLine();
                    if(inputStr.equals("stop"))
                        break;
                    Coordinate coordinate = Input.getCoordinateFromStr(inputStr, this);
                    getMap()[coordinate.getY()][coordinate.getX()] = new Cell(new AliveCellState(CellMark.PlayerOne));
                    render(inputPlayer);
                }

                setMap(helper.mirrorMapHorizontally(getMap()));

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

        for(int i = 0; i < getMap().length; i++)
            for(int j = 0; j < getMap()[i].length; j++)
                if(getMap()[i][j].getState().isAlive())
                    playersLeft.add(getMap()[i][j].getState().getMark());

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
            ui.update(getMap(), generationCount, player);
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Cell[][] getMap() {
        return map;
    }

    public void setMap(Cell[][] map) {
        this.map = map;
    }
}
