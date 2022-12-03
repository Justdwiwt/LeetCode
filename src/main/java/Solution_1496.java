package main.java;

import java.util.ArrayList;
import java.util.List;

public class Solution_1496 {
    public boolean isPathCrossing(String path) {
        List<Integer> res = new ArrayList<>();
        res.add(0);
        int x = 0, y = 0;
        for (int i = 0; i < path.length(); i++) {
            if (path.charAt(i) == 'N') y++;
            else if (path.charAt(i) == 'S') y--;
            else if (path.charAt(i) == 'E') x++;
            else if (path.charAt(i) == 'W') x--;
            if (res.contains(x * 10001 + y)) return true;
            res.add(x * 10001 + y);
        }
        return false;
    }
}
