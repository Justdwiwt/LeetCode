package main.java;

public class Solution_2079 {
    public int wateringPlants(int[] plants, int capacity) {
        int remCap = capacity, steps = 0;
        for (int i = 0; i < plants.length; i++, steps++) {
            if (plants[i] > remCap) {
                steps += (i * 2);
                remCap = capacity;
            }
            remCap -= plants[i];
        }
        return steps;
    }
}
