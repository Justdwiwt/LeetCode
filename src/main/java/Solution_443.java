package main.java;

public class Solution_443 {
    public int compress(char[] chars) {
        int res = 0, count = 1;
        for (int i = 1; i <= chars.length; i++)
            if (i < chars.length && chars[i] == chars[i - 1]) count++;
            else {
                chars[res] = chars[i - 1];
                res++;
                if (count > 1) {
                    for (char c : String.valueOf(count).toCharArray()) {
                        chars[res] = c;
                        res++;
                    }
                }
                count = 1;
            }
        return res;
    }
}
