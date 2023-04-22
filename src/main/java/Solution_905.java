package main.java;

public class Solution_905 {
    public int[] sortArrayByParity(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right)
            if ((nums[left] & 1) == 0) left++;
            else {
                swap(nums, left, right);
                right--;
            }
        return nums;
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
