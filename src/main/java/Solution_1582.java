package main.java;

import java.util.HashMap;

public class Solution_1582 {
    public int numSpecial(int[][] mat) {
        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();
        for (int i = 0; i < mat.length; i++)
            for (int j = 0; j < mat[i].length; j++)
                if (mat[i][j] == 1) {
                    map1.put(i, map1.getOrDefault(i, 0) + 1);
                    map2.put(j, map2.getOrDefault(j, 0) + 1);
                }
        int res = 0;
        for (int i = 0; i < mat.length; i++)
            for (int j = 0; j < mat[i].length; j++)
                if (mat[i][j] == 1 && map1.get(i) == 1 && map2.get(j) == 1)
                    res++;
        return res;
    }
}
