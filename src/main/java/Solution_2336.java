package main.java;

import java.util.HashSet;

public class Solution_2336 {
    static class SmallestInfiniteSet {
        HashSet<Integer> set;

        public SmallestInfiniteSet() {
            set = new HashSet<>();
        }

        public int popSmallest() {
            int res = 1;
            while (set.contains(res)) res++;
            set.add(res);
            return res;
        }

        public void addBack(int num) {
            set.remove(num);
        }
    }
}
