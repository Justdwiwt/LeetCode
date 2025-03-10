package main.java;

public class Solution_2531 {
    public boolean isItPossible(String word1, String word2) {
        int[] num1 = new int[26];
        int[] num2 = new int[26];
        int count1 = 0, count2 = 0;
        for (int i = 0; i < word1.length(); i++) {
            int index = word1.charAt(i) - 'a';
            num1[index]++;
            if (num1[index] == 1) count1++;
        }
        for (int i = 0; i < word2.length(); i++) {
            int index = word2.charAt(i) - 'a';
            num2[index]++;
            if (num2[index] == 1) count2++;
        }
        for (int i = 0; i < 26; i++) {
            if (num1[i] == 0) continue;
            for (int j = 0; j < 26; j++) {
                if (num2[j] == 0) continue;
                int cnt1 = count1, cnt2 = count2;
                if (i == j) {
                    if (cnt1 == cnt2) return true;
                    continue;
                }
                if (1 == num1[i]) cnt1--;
                if (0 == num1[j]) cnt1++;
                if (1 == num2[j]) cnt2--;
                if (0 == num2[i]) cnt2++;
                if (cnt1 == cnt2) return true;
            }
        }
        return false;
    }
}
