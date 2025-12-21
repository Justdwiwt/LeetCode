package main.java;

public class Solution_2953 {
    public int countCompleteSubstrings(String word, int k) {
        int n = word.length(), ans = 0;
        for (int i = 0, j = 1; i < n; j++) {
            while (j < n && Math.abs(word.charAt(j) - word.charAt(j - 1)) <= 2)
                j++;
            for (int p = k; p <= j - i && p <= k * 26; p += k) {
                int[] count = new int[26];
                int num = 0;
                for (int pos = i; pos < i + p; pos++) {
                    int a = word.charAt(pos) - 'a';
                    count[a]++;
                    if (count[a] == k) num++;
                    else if (count[a] == k + 1) num--;
                }
                if (num == p / k) ans++;
                for (int pos = i + p; pos < j; pos++) {
                    int a = word.charAt(pos) - 'a';
                    count[a]++;
                    if (count[a] == k) num++;
                    else if (count[a] == k + 1) num--;
                    a = word.charAt(pos - p) - 'a';
                    count[a]--;
                    if (count[a] == k) num++;
                    else if (count[a] == k - 1) num--;
                    if (num == p / k) ans++;
                }
            }
            i = j;
        }
        return ans;
    }
}
