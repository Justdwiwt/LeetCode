package main.java;

public class Solution_2844 {
    public int minimumOperations(String num) {
        int n = num.length(), ans = (int) (n - num.chars().filter(c -> c == '0').count());
        String[] ops = new String[]{"00", "25", "50", "75"};
        for (String s : ops) {
            int i = n - 1, cnt = 0;
            while (i >= 0 && num.charAt(i) != s.charAt(1)) {
                i--;
                cnt++;
            }
            if (i >= 0) {
                int j = i - 1;
                while (j >= 0 && num.charAt(j) != s.charAt(0)) {
                    j--;
                    cnt++;
                }
                if (j >= 0) ans = Math.min(ans, cnt);
            }
        }
        return ans;
    }
}
