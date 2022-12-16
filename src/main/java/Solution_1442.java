package main.java;

public class Solution_1442 {
    public int countTriplets(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            int n = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                n ^= arr[j];
                if (n == 0) sum += j - i;
            }
        }
        return sum;
    }
}
