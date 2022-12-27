package main.java;

public class Solution_1400 {
    public boolean canConstruct(String s, int k) {
        if (s.length() < k) return false;
        int state = 0;
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            state ^= (1 << index);
        }
        int sum = 0;
        for (int i = 0; i < 32; i++)
            if (((state >> i) & 1) == 1)
                sum++;
        return sum <= k;
    }
}
