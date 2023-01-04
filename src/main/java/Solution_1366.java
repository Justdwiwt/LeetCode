package main.java;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class Solution_1366 {
    public String rankTeams(String[] votes) {
        int n = votes[0].length();
        int[][] cnt = new int[26][n];
        Arrays.stream(votes).forEach(str -> IntStream.range(0, n).forEach(i -> cnt[str.charAt(i) - 'A'][i]++));
        PriorityQueue<Character> que = new PriorityQueue<>((a, b) -> {
            for (int i = 0; i < n; i++)
                if (cnt[a - 'A'][i] != cnt[b - 'A'][i])
                    return cnt[b - 'A'][i] - cnt[a - 'A'][i];
            return a - b;
        });
        for (char c : votes[0].toCharArray()) que.offer(c);
        StringBuilder sb = new StringBuilder();
        while (!que.isEmpty()) sb.append(que.poll());
        return sb.toString();
    }
}
