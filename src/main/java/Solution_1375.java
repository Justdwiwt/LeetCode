package main.java;

public class Solution_1375 {
    public int numTimesAllBlue(int[] light) {
        int size = light.length;
        int cnt = 0, maxReachingPoint = 0;
        for (int i = 0; i < size; i++) {
            maxReachingPoint = Math.max(maxReachingPoint, light[i]);
            if (i + 1 == maxReachingPoint) cnt += 1;
        }
        return cnt;
    }
}
