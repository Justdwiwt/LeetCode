package main.java;

public class Solution_423 {
    public String originalDigits(String s) {
        int[] arr = new int[26];
        for (int c : s.toCharArray()) arr[c - 'a']++;
        int[] res = new int[10];
        res[0] = arr['z' - 'a'];
        res[2] = arr['w' - 'a'];
        res[4] = arr['u' - 'a'];
        res[6] = arr['x' - 'a'];
        res[8] = arr['g' - 'a'];
        res[3] = arr['h' - 'a'] - res[8];
        res[5] = arr['f' - 'a'] - res[4];
        res[7] = arr['s' - 'a'] - res[6];
        res[9] = arr['i' - 'a'] - res[5] - res[6] - res[8];
        res[1] = arr['n' - 'a'] - res[7] - res[9] - res[9];
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 10; i++)
            for (int j = 0; j < res[i]; j++) builder.append(i);
        return builder.toString();
    }
}
