package main.java;

import java.util.ArrayList;
import java.util.List;

public class Solution_1414 {
    private int lowerBound(List<Integer> arr, int target) {
        int left = 1, right = arr.size() - 1;
        while (left + 1 < right) {
            int mid = (left + right) >>> 1;
            if (arr.get(mid) >= target) right = mid;
            else left = mid;
        }
        return arr.get(right) <= target ? right : left;
    }

    public int findMinFibonacciNumbers(int k) {
        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(1);
        while (arr.get(arr.size() - 1) < k)
            arr.add(arr.get(arr.size() - 1) + arr.get(arr.size() - 2));
        int res = 0;
        while (k > 0) {
            int ind = lowerBound(arr, k);
            k -= arr.get(ind);
            res++;
        }
        return res;
    }
}
