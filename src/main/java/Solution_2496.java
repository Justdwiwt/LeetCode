package main.java;

public class Solution_2496 {
    public int maximumValue(String[] strs) {
        int res = 0;
        for (String str : strs)
            try {
                int x = Integer.parseInt(str);
                res = Math.max(res, x);
            } catch (Exception e) {
                res = Math.max(res, str.length());
            }
        return res;
    }
}
