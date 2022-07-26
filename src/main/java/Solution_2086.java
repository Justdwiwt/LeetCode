package main.java;

public class Solution_2086 {
    public int minimumBuckets(String street) {
        int len = street.length();
        int cnt = 0;
        for (int i = 0; i < len; i++)
            if (street.charAt(i) == 'H')
                if (i + 1 < len && street.charAt(i + 1) == '.') {
                    cnt++;
                    i += 2;
                } else if (i - 1 >= 0 && street.charAt(i - 1) == '.') cnt++;
                else return -1;
        return cnt;
    }
}
