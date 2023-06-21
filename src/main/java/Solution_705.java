package main.java;

public class Solution_705 {
    static class MyHashSet {
        boolean[] map = new boolean[1000005];

        public MyHashSet() {

        }

        public void add(int key) {
            map[key] = true;
        }

        public void remove(int key) {
            map[key] = false;
        }


        public boolean contains(int key) {
            return map[key];
        }
    }
}
