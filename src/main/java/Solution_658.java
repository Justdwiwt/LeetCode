package main.java;

import java.util.ArrayList;
import java.util.List;

public class Solution_658 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0, right = 0, sum = 0, min = Integer.MAX_VALUE, a = 0, b = 0;
        while (right < arr.length) {
            sum += Math.abs(arr[right] - x);
            right++;
            while (right - left == k) {
                if (sum < min) {
                    a = left;
                    b = right;
                    min = sum;
                }
                sum -= Math.abs(arr[left] - x);
                left++;
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = a; i < b; i++) {
            list.add(arr[i]);
        }
        return list;
    }
}
