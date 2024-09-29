package main.java;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution_2343 {
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        return Arrays.stream(queries).mapToInt(query -> help(nums, query)).toArray();
    }

    private int help(String[] nums, int[] arr) {
        String[][] temp = new String[nums.length][2];
        IntStream.range(0, nums.length).forEach(i -> {
            temp[i][0] = nums[i].substring(nums[i].length() - arr[1]);
            temp[i][1] = i + "";
        });
        Arrays.sort(temp, (a, b) -> {
            if (a[0].equals(b[0])) return Integer.parseInt(a[1]) - Integer.parseInt(b[1]);
            return a[0].compareTo(b[0]);
        });
        return Integer.parseInt(temp[arr[0] - 1][1]);
    }
}
