package main.java;

import java.util.Arrays;

public class Solution_706 {
    static class MyHashMap {
        int[] values;

        public MyHashMap() {
            values = new int[1000001];
            Arrays.fill(values, -1);
        }

        public void put(int key, int value) {
            values[key] = value;
        }

        public int get(int key) {
            return values[key];
        }

        public void remove(int key) {
            values[key] = -1;
        }
    }
}
