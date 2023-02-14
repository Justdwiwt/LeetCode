package main.java;

public class Solution_1184 {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int total = 0, sum = 0, l = Math.min(start, destination), r = Math.max(start, destination);
        for (int i = 0; i < distance.length; i++) {
            total += distance[i];
            if (i >= l && i < r) sum += distance[i];
        }
        return Math.min(sum, total - sum);
    }
}
