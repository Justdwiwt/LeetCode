package main.java;

public class Solution_3005 {
    public int maxFrequencyElements(int[] nums) {
        int ans = 0;
        int[] map = new int[101];
        int max = 0;
        for (int num : nums) {
            map[num]++;
            max = Math.max(max, map[num]);
        }
        for (int i : map) ans = i == max ? ans + i : ans;
        return ans;
    }
}
