package main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> listAll = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);
        find(listAll, list, candidates, target, 0);
        return listAll;
    }

    public void find(List<List<Integer>> listAll, List<Integer> tmp, int[] candidates, int target, int num) {
        if (target == 0) {
            listAll.add(tmp);
            return;
        }
        if (target < candidates[0]) return;
        for (int i = num; i < candidates.length && candidates[i] <= target; i++) {
            List<Integer> list = new ArrayList<>(tmp);
            list.add(candidates[i]);
            find(listAll, list, candidates, target - candidates[i], i);
        }
    }
}
