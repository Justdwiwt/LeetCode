package main.java;

public class Solution_923 {
    public int threeSumMulti(int[] arr, int target) {
        long res = 0L;
        int[] cnt = new int[101];
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int t = target - arr[i] - arr[j];
                if (t >= 0 && t < cnt.length) res += cnt[t];
            }
            cnt[arr[i]]++;
        }
        return (int) (res % 1000000007);
    }
}
