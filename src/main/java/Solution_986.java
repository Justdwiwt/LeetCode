package main.java;

import java.util.ArrayList;
import java.util.List;

public class Solution_986 {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> res = new ArrayList<>();
        int l = 0;
        int r = 0;
        while (l < firstList.length && r < secondList.length) {
            int start = Math.max(firstList[l][0], secondList[r][0]);
            int end = Math.min(firstList[l][1], secondList[r][1]);
            if (start <= end) res.add(new int[]{start, end});
            if (firstList[l][1] < secondList[r][1]) l++;
            else r++;
        }
        return res.toArray(new int[0][]);
    }
}
