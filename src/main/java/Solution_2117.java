package main.java;

public class Solution_2117 {
    public String abbreviateProduct(int left, int right) {
        long suf = 1;
        int zeros = 0, orgDigits = 0;
        double prod = 1.0;
        for (int n = left; n <= right; n++) {
            prod *= n;
            while (prod >= 1.0) {
                prod /= 10.0;
                orgDigits++;
            }
            suf *= n;
            while (suf % 10 == 0) {
                zeros++;
                suf /= 10;
            }
            if (suf > Math.pow(10, 14)) suf %= (long) Math.pow(10, 14);
        }
        if (orgDigits - zeros <= 10)
            return (long) (prod * Math.pow(10, orgDigits - zeros) + 0.5) + "e" + zeros;
        else {
            String str_suf = "0000" + suf;
            return (int) (prod * 100000) + "..." + str_suf.substring(str_suf.length() - 5) + 'e' + zeros;
        }
    }
}
