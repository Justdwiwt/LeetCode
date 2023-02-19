package main.java;

import java.util.TreeMap;
import java.util.stream.IntStream;

public class Solution_1146 {
    static class SnapshotArray {
        TreeMap<Integer, Integer>[] arr;
        int sid = 0;

        public SnapshotArray(int length) {
            arr = new TreeMap[length];

            IntStream.range(0, length).forEach(i -> {
                arr[i] = new TreeMap<>();
                arr[i].put(0, 0);
            });
        }

        public void set(int index, int val) {
            arr[index].put(sid, val);
        }

        public int snap() {
            return sid++;
        }

        public int get(int index, int snap_id) {
            return arr[index].floorEntry(snap_id).getValue();
        }
    }
}
