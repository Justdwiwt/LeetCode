package main.java;

import java.util.ArrayList;

public class Solution_1992 {
    public int[][] findFarmland(int[][] land) {
        ArrayList<int[]> res = new ArrayList<>();
        for (int r = 0; r < land.length; r++)
            for (int c = 0; c < land[0].length; c++)
                if (land[r][c] == 1) {
                    if (c - 1 >= 0 && land[r][c - 1] == 1 || r - 1 >= 0 && land[r - 1][c] == 1)
                        continue;
                    int rr = r;
                    while (rr < land.length && land[rr][c] == 1) rr++;
                    int cc = c;
                    while (cc < land[0].length && land[r][cc] == 1) cc++;
                    res.add(new int[]{r, c, rr - 1, cc - 1});
                }
        return res.toArray(new int[0][]);
    }
}
