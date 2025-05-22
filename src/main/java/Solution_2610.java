package main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_2610 {
    public List<List<Integer>> findMatrix(int[] nums) {
        int n = nums.length;
        int[] let = new int[n + 1];
        Arrays.stream(nums).forEach(num -> let[num]++);
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 1; i <= n; i++)
            for (int j = 0; j < let[i]; j++) {
                if (j >= lists.size()) lists.add(new ArrayList<>());
                lists.get(j).add(i);
            }
        return lists;
    }
}
