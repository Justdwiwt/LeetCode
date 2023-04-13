package main.java;

public class Solution_927 {
    public int[] threeEqualParts(int[] arr) {
        int n = arr.length, cnt = 0, tailZeros = 0;
        int[] ones = new int[n];
        for (int i = 0; i < n; ++i) if (arr[i] == 1) ones[cnt++] = i;
        int[] def = {-1, -1};
        if (cnt == 0) return new int[]{0, n - 1};
        if (cnt % 3 != 0) return def;
        cnt /= 3;
        for (int i = n - 1; arr[i] != 1; i--) tailZeros++;
        int tail1 = ones[cnt - 1], tail2 = ones[cnt * 2 - 1];
        for (int i = 0; i < tailZeros; ++i) {
            tail1++;
            tail2++;
            if (arr[tail1] != 0 || arr[tail2] != 0) return def;
        }
        for (int i = tail1, j = tail2, k = n - 1; i >= 0 && j > tail1 && k > tail2; i--, j--, k--)
            if (arr[i] != arr[j] || arr[i] != arr[k]) return def;
        return new int[]{tail1, tail2 + 1};
    }
}
