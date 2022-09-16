package main.java;

import java.util.TreeSet;
import java.util.stream.IntStream;

public class Solution_1845 {
    static class SeatManager {
        TreeSet<Integer> ts;

        public SeatManager(int n) {
            ts = new TreeSet<>();
            IntStream.rangeClosed(1, n).forEach(i -> ts.add(i));
        }

        public int reserve() {
            return ts.pollFirst();
        }

        public void unreserve(int seatNumber) {
            ts.add(seatNumber);
        }
    }
}
