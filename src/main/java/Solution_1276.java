package main.java;

import java.util.ArrayList;
import java.util.List;

public class Solution_1276 {
    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        return ((tomatoSlices & 1) != 0 || (tomatoSlices > (cheeseSlices << 2)) || tomatoSlices < (cheeseSlices << 1)) ? new ArrayList<>() : new ArrayList<Integer>() {{
            add((tomatoSlices - (cheeseSlices << 1) >> 1));
            add(cheeseSlices - (tomatoSlices - (cheeseSlices << 1) >> 1));
        }};
    }
}
