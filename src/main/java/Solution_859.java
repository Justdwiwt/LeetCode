package main.java;

public class Solution_859 {
    public boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length()) return false;
        int cnt = 0, i1 = -1, i2 = -1;
        char[] arr1 = s.toCharArray();
        char[] arr2 = goal.toCharArray();
        int len = arr1.length;
        boolean flag = false;
        int[] tmp = new int[26];
        for (int i = 0; i < len; i++) {
            if (!flag && ++tmp[s.charAt(i) - 'a'] > 1) flag = true;
            if (arr1[i] != arr2[i]) {
                cnt++;
                if (cnt == 3) return false;
                if (cnt == 1) i1 = i;
                if (cnt == 2) i2 = i;
            }
        }
        return cnt != 1 && (cnt == 0 ? flag : arr1[i1] == arr2[i2] && arr1[i2] == arr2[i1]);
    }
}
