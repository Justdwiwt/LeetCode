package main.java;

public class Solution_2087 {
    public int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
        int sum = 0;
        while (startPos[0] != homePos[0])
            sum += startPos[0] < homePos[0] ? rowCosts[++startPos[0]] : rowCosts[--startPos[0]];
        while (startPos[1] != homePos[1])
            sum += startPos[1] < homePos[1] ? colCosts[++startPos[1]] : colCosts[--startPos[1]];
        return sum;
    }
}
