package main.java;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.stream.IntStream;

public class Solution_906 {
    public int superpalindromesInRange(String left, String right) {
        if ("0".equals(right)) return 1;
        int res = 0;
        long l = Long.parseLong(left);
        long r = Long.parseLong(right);
        Queue<String> queue = new ArrayDeque<>();
        String[] turn = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        IntStream.range(1, 10).forEach(i -> {
            queue.offer(turn[i]);
            queue.offer(turn[i] + turn[i]);
        });
        while (!queue.isEmpty()) {
            String temp = queue.poll();
            if (temp.length() > 10) continue;
            long tmp = Long.parseLong(temp);
            if (tmp * tmp < 0) continue;
            if (tmp * tmp <= r) {
                StringBuilder buf = new StringBuilder();
                buf.append(tmp * tmp);
                if (tmp * tmp >= l && buf.toString().equals(buf.reverse().toString())) res++;
                if (temp.length() % 2 == 0) Arrays.stream(turn).forEach(s -> {
                    queue.offer(temp.substring(0, temp.length() / 2) + s + temp.substring(temp.length() / 2));
                    queue.offer(temp.substring(0, temp.length() / 2) + s + s + temp.substring(temp.length() / 2));
                });
            }
        }
        return res;
    }
}
