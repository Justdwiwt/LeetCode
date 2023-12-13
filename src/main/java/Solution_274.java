package main.java;

import java.util.Arrays;

public class Solution_274 {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int h=citations.length;
        for (int citation : citations)
            if (citation < h) h--;
        return h;
    }
}
