package main.java;

import java.util.Arrays;
import java.util.Comparator;

public class Solution_2271 {
    public int maximumWhiteTiles(int[][] tiles, int carpetLen) {
        Arrays.sort(tiles, Comparator.comparingInt(a -> a[0]));
        int res = 0, sum = 0;
        for (int i = 0, j = 0; i < tiles.length && j < tiles.length; i++) {
            if (carpetLen <= tiles[i][1] - tiles[i][0] + 1)
                return carpetLen;
            while (j < tiles.length && tiles[j][1] < carpetLen + tiles[i][0]) {
                sum += tiles[j][1] - tiles[j][0] + 1;
                j++;
            }
            if (j == tiles.length || tiles[i][0] + carpetLen <= tiles[j][0])
                res = Math.max(res, sum);
            else
                res = Math.max(res, sum + carpetLen + tiles[i][0] - tiles[j][0]);
            sum = Math.max(0, sum - tiles[i][1] + tiles[i][0] - 1);
        }
        return res;
    }
}
