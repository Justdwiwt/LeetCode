package main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_40 {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> list = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates, target, 0);
        return result;
    }

    private void dfs(int[] candidates, int target, int start) {
        if (target < 0) return;

        if (target == 0) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i < candidates.length; ++i) {
            int one = candidates[i];
            list.add(one);
            dfs(candidates, target - one, i + 1);
            list.remove(list.size() - 1);
            while (i < candidates.length - 1 && candidates[i] == candidates[i + 1]) ++i;
        }
    }
}
