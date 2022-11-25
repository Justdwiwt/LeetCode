package main.java;

public class Solution_1534 {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int res = 0;
        for (int i = 0; i < arr.length - 2; i++)
            for (int j = i + 1; j < arr.length - 1; j++)
                if (Math.abs(arr[i] - arr[j]) <= a) {
                    for (int k = j + 1; k < arr.length; k++)
                        if (Math.abs(arr[k] - arr[j]) <= b && Math.abs(arr[k] - arr[i]) <= c)
                            res++;
                }
        return res;
    }
}
