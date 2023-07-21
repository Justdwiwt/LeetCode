package main.java;

public class Solution_564 {
    public String nearestPalindromic(String n) {
        String s = String.valueOf(n);
        Long sVal = Long.valueOf(s);
        int len = s.length();
        if (len == 1) return String.valueOf(sVal - 1);
        String half = s.substring(0, (len + 1) / 2);
        long halfVal = Long.parseLong(half);
        String res = "";
        for (long i = halfVal - 1; i <= halfVal + 1; i++) {
            String left = String.valueOf(i);
            String cur;
            if (left.length() > half.length()) cur = String.valueOf((long) Math.pow(10, len) + 1);
            else if (left.length() < half.length()) cur = String.valueOf((long) Math.pow(10, len - 1) - 1);
            else if (i == 0) cur = String.valueOf((long) Math.pow(10, len - 1) - 1);
            else {
                String right = new StringBuilder(left).reverse().toString();
                if (len % 2 == 0) cur = left + right;
                else cur = left + right.substring(1);
            }
            if (cur.equals(s)) continue;
            if ("".equals(res)) res = cur;
            else {
                Long curVal = Long.valueOf(cur);
                Long preVal = Long.valueOf(res);
                long diff = Math.abs(curVal - sVal) - Math.abs(preVal - sVal);
                if (diff < 0 || (diff == 0 && curVal < preVal)) res = cur;
            }
        }
        return res;
    }
}
