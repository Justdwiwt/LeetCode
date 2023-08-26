package main.java;

import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;

public class Solution_433 {
    public int minMutation(String start, String end, String[] bank) {
        boolean[] status = new boolean[bank.length];
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        int cnt = 0;
        while (!queue.isEmpty()) {
            for (int size = queue.size(); size > 0; size--) {
                String cur = queue.poll();
                if (cur != null && cur.equals(end)) return cnt;
                IntStream.range(0, bank.length).filter(i -> !status[i]).filter(i -> countDis(cur, bank[i]) == 1).forEach(i -> {
                    status[i] = true;
                    queue.offer(bank[i]);
                });
            }
            cnt++;
        }
        return -1;
    }

    private int countDis(String a, String b) {
        return (int) IntStream.range(0, 8).filter(i -> a.charAt(i) != b.charAt(i)).count();
    }
}
