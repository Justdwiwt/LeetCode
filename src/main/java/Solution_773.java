package main.java;

import java.util.*;

public class Solution_773 {
    private final int[][] diff = {{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}};

    public int slidingPuzzle(int[][] board) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 2; i++)
            for (int j = 0; j < 3; j++)
                sb.append(board[i][j]);
        String init = sb.toString();
        if (init.equals("123450")) return 0;
        int step = 0;
        Queue<String> queue = new LinkedList<>();
        queue.offer(init);
        Set<String> visit = new HashSet<>();
        visit.add(init);
        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String p = queue.poll();
                assert p != null;
                for (String next : next(p))
                    if (!visit.contains(next)) {
                        if (next.equals("123450")) return step;
                        queue.offer(next);
                        visit.add(next);
                    }
            }
        }
        return -1;
    }

    private List<String> next(String p) {
        List<String> res = new LinkedList<>();
        char[] array = p.toCharArray();
        int place0 = p.indexOf('0');
        Arrays.stream(diff[place0]).forEach(x -> {
            char i = array[place0];
            array[place0] = array[x];
            array[x] = i;
            res.add(new String(array));
            char j = array[place0];
            array[place0] = array[x];
            array[x] = j;
        });
        return res;
    }
}
