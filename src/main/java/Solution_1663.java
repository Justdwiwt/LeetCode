package main.java;

public class Solution_1663 {
    public String getSmallestString(int n, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = 26; i >= 1; i--) {
            while (k - i >= 0 && k - i >= n - 1) {
                k -= i;
                n--;
                sb.append((char) (i - 1 + 'a'));
            }
            if (n == k - i) {
                sb.append('a');
                break;
            }
        }
        return sb.reverse().toString();
    }
}
