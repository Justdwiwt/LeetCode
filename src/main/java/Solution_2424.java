package main.java;

import java.util.TreeSet;
import java.util.stream.IntStream;

public class Solution_2424 {
    static class LUPrefix {
        private final TreeSet<Integer> set;

        public LUPrefix(int n) {
            set = new TreeSet<>();
            IntStream.rangeClosed(1, n + 1).forEach(set::add);
        }

        public void upload(int video) {
            set.remove(video);
        }

        public int longest() {
            return set.first() - 1;
        }
    }
}
