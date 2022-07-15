package main.java;

import java.util.Arrays;

public class Solution_2126 {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long m = mass;
        for (int asteroid : asteroids) {
            if (m < asteroid)
                return false;
            m += asteroid;
        }
        return true;
    }
}
