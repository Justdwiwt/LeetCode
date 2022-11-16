package main.java;

public class Solution_1574 {
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length, left = 0, right = n - 1, res;
        while (left + 1 < n && arr[left] <= arr[left + 1]) left++;
        while (right > 0 && arr[right] >= arr[right - 1]) right--;
        if (left >= right) return 0;
        res = Math.min(n - left - 1, right);
        for (int k = 0; k <= left; k++) {
            int i = right, j = n - 1;
            while (i < j) {
                int mid = (i + j) >>> 1;
                if (arr[mid] >= arr[k]) j = mid;
                else i = mid + 1;
            }
            if (arr[i] < arr[k]) res = Math.min(res, i - k);
            else res = Math.min(res, i - k - 1);
        }
        return res;
    }
}
