package main.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution_1125 {
    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        final int N = req_skills.length, M = people.size();
        Map<String, Integer> map = IntStream.range(0, N).boxed().collect(Collectors.toMap(i -> req_skills[i], i -> i, (a, b) -> b));
        int[] sk = new int[M];
        IntStream.range(0, M).forEach(i -> people.get(i).forEach(s -> sk[i] |= (1 << map.get(s))));
        int maxState = 0;
        List<Integer>[] dp = new List[1 << N];
        dp[0] = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            if (sk[i] == 0) continue;
            for (int j = 0; j <= maxState; j++) {
                if (dp[j] == null) continue;
                int nextState = j | sk[i];
                if (j != nextState && (dp[nextState] == null || dp[j].size() + 1 < dp[nextState].size())) {
                    dp[nextState] = new ArrayList<>(dp[j]);
                    dp[nextState].add(i);
                }
                maxState |= sk[i];
            }
        }
        return dp[(1 << N) - 1].stream().mapToInt(i -> i).toArray();
    }
}
