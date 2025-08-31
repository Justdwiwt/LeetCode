package main.java;

public class Solution_2799 {
    public int countCompleteSubarrays(int[] nums) {
        int[] array = new int[2001];
        int max = -1;
        int kind = 0;
        for (int num : nums) {
            if (array[num]++ == 0) kind++;
            max = Math.max(max, num);
        }
        int ans = 0, left = 0, right = 0, count = 0;
        int[] arr = new int[max + 1];
        for (; right < nums.length; right++) {
            if (arr[nums[right]]++ == 0) count++;
            while (count == kind) if (arr[nums[left++]]-- == 1) count--;
            ans += left;
        }
        return ans;
    }
}
