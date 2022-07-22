package main.java;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution_2100 {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        int N = security.length;
        int[][] cnt = new int[N][2];
        IntStream.range(1, N).forEach(i -> {
            if (security[i - 1] >= security[i]) cnt[i][0] = cnt[i - 1][0] + 1;
            int idx = N - i - 1;
            if (security[idx] <= security[idx + 1]) cnt[idx][1] = cnt[idx + 1][1] + 1;
        });

        return IntStream.range(time, N - time)
                .filter(i -> cnt[i][0] >= time && cnt[i][1] >= time)
                .boxed()
                .collect(Collectors.toList());
    }
}
