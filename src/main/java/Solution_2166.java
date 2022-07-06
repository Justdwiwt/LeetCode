package main.java;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class Solution_2166 {
    static class Bitset {
        Set<Integer> set = new HashSet<>();
        int size;
        boolean reverse = false;

        public Bitset(int size) {
            this.size = size;
        }

        public void fix(int idx) {
            if (reverse) set.remove(idx);
            else set.add(idx);
        }

        public void unfix(int idx) {
            if (reverse) set.add(idx);
            else set.remove(idx);
        }

        public void flip() {
            reverse = !reverse;
        }

        public boolean all() {
            return set.size() == (reverse ? 0 : size);
        }

        public boolean one() {
            return reverse ? set.size() < size : set.size() > 0;
        }

        public int count() {
            return reverse ? size - set.size() : set.size();
        }

        public String toString() {
            char[] ch = new char[size];
            IntStream.range(0, size).forEach(i -> {
                int v = set.contains(i) ? 1 : 0;
                ch[i] = (char) (reverse ? 1 - v + '0' : v + '0');
            });
            return new String(ch);
        }
    }
}
