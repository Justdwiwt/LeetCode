package main.java;

public class Solution_1864 {
    public int minSwaps(String s) {
        int n = s.length();
        char[] ch = s.toCharArray();
        int[] cnt1 = new int[3];
        int[] cnt2 = new int[3];
        for (int i = 0; i < n; i++) {
            int temp = (ch[i] - '0') - (i % 2 == 0 ? 1 : 0);
            cnt1[temp + 1]++;
            temp = (ch[i] - '0') - (i % 2 == 0 ? 0 : 1);
            cnt2[temp + 1]++;
        }
        int res1 = cnt1[0] == cnt1[2] ? cnt1[0] : Integer.MAX_VALUE;
        int res2 = cnt2[0] == cnt2[2] ? cnt2[0] : Integer.MAX_VALUE;
        return res1 == Integer.MAX_VALUE && res2 == Integer.MAX_VALUE ? -1 : Math.min(res1, res2);
    }
}
