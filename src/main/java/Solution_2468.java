package main.java;

public class Solution_2468 {
    public String[] splitMessage(String message, int limit) {
        int n = message.length();
        char[] ch = message.toCharArray();
        for (int i = 1, cap = 0, tail_len; ; i++) {
            if (i < 10) tail_len = 5;
            else if (i < 100) {
                if (i == 10) cap -= 9;
                tail_len = 7;
            } else if (i < 1000) {
                if (i == 100) cap -= 99;
                tail_len = 9;
            } else {
                if (i == 1000) cap -= 999;
                tail_len = 11;
            }

            if (tail_len >= limit) return new String[]{};
            cap += limit - tail_len;
            if (cap < n) continue;

            String[] ans = new String[i];
            for (int j = 1, k = 0; j <= i; j++) {
                String tail = "<" + j + "/" + i + ">";
                int need = limit - tail.length();
                if (j < i) {
                    ans[j - 1] = String.valueOf(ch, k, need) + tail;
                    k += need;
                } else ans[j - 1] = String.valueOf(ch, k, n - k) + tail;
            }
            return ans;
        }
    }
}
