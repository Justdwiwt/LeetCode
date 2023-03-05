package main.java;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class Solution_1054 {
    public int[] rearrangeBarcodes(int[] barcodes) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Arrays.stream(barcodes).forEach(ele -> map.put(ele, map.getOrDefault(ele, 0) + 1));
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
        map.entrySet().stream().map(entry -> new int[]{entry.getKey(), entry.getValue()}).forEach(queue::offer);
        int[] res = new int[barcodes.length];
        IntStream.range(0, barcodes.length).forEach(i -> {
            int[] e = queue.poll();
            assert e != null;
            int now = e[1] - 1;
            if (i == 0 || (i > 0 && res[i - 1] != e[0])) {
                res[i] = e[0];
                if (now > 0) queue.offer(new int[]{e[0], now});
            } else {
                int[] e2 = queue.poll();
                assert e2 != null;
                int now2 = e2[1] - 1;
                res[i] = e2[0];
                if (now2 > 0) queue.offer(new int[]{e2[0], now2});
                queue.offer(new int[]{e[0], now + 1});
            }
        });
        return res;
    }
}
