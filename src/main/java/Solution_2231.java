package main.java;

import java.util.PriorityQueue;

public class Solution_2231 {
    public int largestInteger(int num) {
        PriorityQueue<Integer> pq1 = new PriorityQueue<>((o1, o2) -> o2 - o1);
        PriorityQueue<Integer> pq2 = new PriorityQueue<>((o1, o2) -> o2 - o1);
        char[] ch = String.valueOf(num).toCharArray();
        for (char c : ch)
            if ((c - '0') % 2 == 0) pq2.add(c - '0');
            else pq1.add(c - '0');
        StringBuilder sb = new StringBuilder();
        for (char c : ch)
            if ((c - '0') % 2 == 0) sb.append(pq2.poll());
            else sb.append(pq1.poll());
        return Integer.parseInt(sb.toString());
    }
}
