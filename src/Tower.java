import java.util.ArrayList;
import java.util.HashMap;

@SuppressWarnings("unused")
public class Tower {
    HashMap<String, ArrayList<Integer>> towers = new HashMap<>();
    int size;
    long startTime;
    public Tower(int size){
        if (size > 10 || size <= 0){
            throw new IllegalArgumentException("Too big of a tower");
        }
        this.size = size;
        ArrayList<Integer> Tower = new ArrayList<>();

        for (int i = size; i > 0; i--) {
            Tower.add(i);
        }
        towers.put("A", Tower);
        towers.put("B", new ArrayList<>());
        towers.put("C",new ArrayList<>());
        startTime = System.currentTimeMillis();
    }

    public boolean checkMove(Move move){
        if (!towers.containsKey(move.start()) || !towers.containsKey(move.end())) {
            return false;
        }
        if (move.start().equals(move.end())) {
            return false;
        }
        ArrayList<Integer> start = towers.get(move.start());
        ArrayList<Integer> end = towers.get(move.end());
        return !start.isEmpty() && (end.isEmpty() || start.getLast() < end.getLast());
    }
    public boolean executeMove(Move move){
        if (checkMove(move)){
            ArrayList<Integer> start = towers.get(move.start());
            ArrayList<Integer> end = towers.get(move.end());

            end.add(start.removeLast());
            return true;
        }
        else return false;
    }
}