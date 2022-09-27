package main.java;

public class Solution_1781 {
    public int beautySum(String s) {
        if (s.isEmpty()) return 0;
        int totalSum = 0;
        char[] ch = s.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            int[] counts = new int[26];
            for (int j = i; j < ch.length; j++) {
                counts[ch[j] - 'a']++;
                int max = Integer.MIN_VALUE;
                int min = Integer.MAX_VALUE;
                for (int cnt : counts)
                    if (cnt > 0) {
                        max = Math.max(max, cnt);
                        min = Math.min(min, cnt);
                    }
                totalSum = totalSum + max - min;
            }
        }
        return totalSum;
    }
}
