package main.java;

import java.util.Arrays;

public class Solution_2502 {
    static class Allocator {
        int totalSize;
        int[] map;

        public Allocator(int n) {
            totalSize = n;
            map = new int[n];
        }

        public int allocate(int size, int mID) {
            int used = 0;
            for (int i = 0; i < totalSize; i++) {
                if (map[i] == 0) used++;
                else used = 0;
                if (used == size) {
                    Arrays.fill(map, i + 1 - size, i + 1, mID);
                    return i + 1 - size;
                }
            }
            return -1;
        }

        public int freeMemory(int mID) {
            int removed = 0;
            for (int i = 0; i < totalSize; i++)
                if (map[i] == mID) {
                    removed++;
                    map[i] = 0;
                }
            return removed;
        }
    }
}
