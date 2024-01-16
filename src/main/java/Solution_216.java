package main.java;

import java.util.ArrayList;
import java.util.List;

public class Solution_216 {
    List<Integer> arr = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();

    private void backTracking(int sum, int n, int k, int startIndex) {
        if (sum == n && arr.size() == k) res.add(new ArrayList<>(arr));

        for (int i = startIndex; i <= 9; i++) {
            arr.add(i);
            sum += i;
            backTracking(sum, n, k, i + 1);
            sum -= i;
            arr.remove(arr.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        backTracking(0, n, k, 1);
        return res;
    }
}
