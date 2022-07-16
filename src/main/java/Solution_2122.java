package main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_2122 {
    public int[] recoverArray(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        boolean[] visited = new boolean[n];
        for (int num : nums) {
            if ((num - nums[0]) % 2 != 0)
                continue;
            int k = (num - nums[0]) / 2;
            if (k == 0)
                continue;
            list.clear();
            Arrays.fill(visited, false);
            for (int i = 0, j = 0; i < n; i++) {
                if (visited[i])
                    continue;
                visited[i] = true;
                while (j < n && (nums[j] < nums[i] + k * 2 || visited[j])) j++;
                if (j < n && nums[j] == nums[i] + k * 2) {
                    list.add(nums[i] + k);
                    visited[j] = true;
                    j++;
                } else break;
            }
            if (list.size() == n / 2) break;
        }

        int[] res = new int[n / 2];
        int idx = 0;
        for (Integer num : list)
            res[idx++] = num;
        return res;
    }
}
