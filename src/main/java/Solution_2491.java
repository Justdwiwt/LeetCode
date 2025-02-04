package main.java;

import java.util.Arrays;

public class Solution_2491 {
    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        int n = skill.length, i = 1, j = n - 2;
        long ans = (long) skill[0] * skill[n - 1], avg = skill[0] + skill[n - 1];
        while (i < j) {
            if (skill[i] + skill[j] != avg) return -1;
            ans += (long) skill[i] * skill[j];
            i++;
            j--;
        }
        return ans;
    }
}
