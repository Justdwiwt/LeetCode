package main.java;

import java.util.ArrayList;
import java.util.List;

public class Solution_1521 {
    public int closestToTarget(int[] arr, int target) {
        int res = Math.abs(arr[0] - target);
        List<Integer> list = new ArrayList<>();
        list.add(arr[0]);
        int N = arr.length;
        for (int i = 1; i < N; i++) {
            List<Integer> newList = new ArrayList<>();
            newList.add(arr[i]);
            res = Math.min(res, Math.abs(arr[i] - target));
            int pre = arr[i];
            for (int num : list) {
                int cur = num & arr[i];
                if (cur != pre) {
                    newList.add(cur);
                    res = Math.min(res, Math.abs(cur - target));
                    pre = cur;
                }
            }
            list = newList;
        }
        return res;
    }
}
