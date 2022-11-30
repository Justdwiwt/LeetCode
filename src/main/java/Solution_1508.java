package main.java;

import java.util.ArrayList;
import java.util.Collections;

public class Solution_1508 {
    public int rangeSum(int[] nums, int n, int left, int right) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int tmp = 0;
            for (int j = 0; j < nums.length - i; j++) {
                tmp += nums[i + j];
                list.add(tmp);
            }
        }
        Collections.sort(list);
        int res = 0;
        for (int i = left - 1; i <= right - 1; i++)
            res = (res + list.get(i)) % 1000000007;
        return res;
    }
}
