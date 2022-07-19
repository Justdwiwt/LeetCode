package main.java;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Solution_2111 {
    public int kIncreasing(int[] arr, int k) {
        int total = 0;
        for (int i = 0; i < k; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = i; j < arr.length; j = j + k)
                list.add(arr[j]);
            total += list.size() - lengthOfLIS(list);
        }
        return total;
    }

    private int lengthOfLIS(List<Integer> nums) {
        List<Integer> incrList = new ArrayList<>();
        incrList.add(nums.get(0));

        IntStream.range(1, nums.size()).forEach(i -> {
            int lastItem = incrList.get(incrList.size() - 1);
            if (nums.get(i) >= lastItem)
                incrList.add(nums.get(i));
            else {
                int idx = nextGreaterItem(incrList, nums.get(i));
                incrList.set(idx, nums.get(i));
            }
        });
        return incrList.size();
    }

    private int nextGreaterItem(List<Integer> list, int num) {
        int left = 0, right = list.size() - 1;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (num >= list.get(mid)) left = mid + 1;
            else right = mid;
        }
        return left;
    }
}
