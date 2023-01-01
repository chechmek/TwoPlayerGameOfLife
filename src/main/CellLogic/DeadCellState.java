package main.CellLogic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DeadCellState extends CellStateBase{
    public DeadCellState(){
        mark = CellMark.Empty;
    }

    @Override
    public CellState getNewState(List<Cell> neighbours) {
        // if 3 neighbours set alive state of player
        if(neighbours.size() != 3)
            return this;

        List<CellMark> marks = new ArrayList<>();
        for(Cell cell : neighbours)
            marks.add(cell.getState().getMark());

        CellMark mostCommon = mostCommon(marks);

        return new AliveCellState(mostCommon);
    }

    @Override
    public boolean isAlive() {
        return false;
    }

    private <T> T mostCommon(List<T> list) {
        Map<T, Integer> map = new HashMap<>();

        for (T t : list) {
            Integer val = map.get(t);
            map.put(t, val == null ? 1 : val + 1);
        }

        Map.Entry<T, Integer> max = null;

        for (Map.Entry<T, Integer> e : map.entrySet()) {
            if (max == null || e.getValue() > max.getValue())
                max = e;
        }

        return max.getKey();
    }
}
