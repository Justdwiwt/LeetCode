package main.java;

public class Solution_2957 {
    public int removeAlmostEqualCharacters(String word) {
        int res = 0;
        char[] strs = word.toCharArray();
        for (int i = 0; i < strs.length - 1; i++)
            if ((strs[i] + 1 == strs[i + 1]) || (strs[i] == strs[i + 1]) || (strs[i] - 1 == strs[i + 1])) {
                strs[i + 1] = '@';
                res++;
            }
        return res;
    }
}
