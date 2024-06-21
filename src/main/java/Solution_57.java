package main.java;

public class Solution_57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int l = binarySearch(intervals, newInterval[0], 1);
        int r = binarySearch(intervals, newInterval[1], 0);
        int n = intervals.length;
        int[][] res = new int[n - r + l + 1][2];
        System.arraycopy(intervals, 0, res, 0, l);
        if (l != r) {
            newInterval[0] = Math.min(intervals[l][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[r - 1][1], newInterval[1]);
        }
        res[l] = new int[]{newInterval[0], newInterval[1]};
        System.arraycopy(intervals, r, res, l + 1, n - r);
        return res;
    }

    int binarySearch(int[][] arr, int target, int i) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = (low + high) >>> 1;
            if (arr[mid][i] > target) high = mid;
            else if (arr[mid][i] < target) low = mid + 1;
            else return mid + 1 - i;
        }
        return high;
    }
}
