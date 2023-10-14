package main.java;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution_373 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> (o2[0] + o2[1]) - (o1[0] + o1[1]));
        for (int value : nums1) {
            for (int i : nums2) {
                int[] res = new int[]{value, i};
                if (pq.size() < k) pq.add(res);
                else {
                    assert pq.peek() != null;
                    if ((res[0] + res[1]) < pq.peek()[0] + pq.peek()[1]) {
                        pq.remove();
                        pq.add(res);
                    } else if ((res[0] + res[1]) >= pq.peek()[0] + pq.peek()[1]) break;
                }
            }
        }
        while (!pq.isEmpty()) {
            List<Integer> l = new ArrayList<>();
            int[] i = pq.remove();
            l.add(i[0]);
            l.add(i[1]);
            result.add(l);
        }
        return result;
    }
}
