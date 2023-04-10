package main.java;

public class Solution_941 {
    public boolean validMountainArray(int[] A) {
        if (A.length < 3) return false;
        int left = 0, right = A.length - 1;
        while (left < A.length - 2 && A[left] < A[left + 1]) left++;
        while (right > 1 && A[right] < A[right - 1]) right--;
        return left == right;
    }
}
