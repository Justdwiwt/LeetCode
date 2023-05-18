package main.java;

import java.util.Arrays;

public class Solution_825 {
    public int numFriendRequests(int[] ages) {
        int[] ageCount = new int[121];
        int res = 0;
        Arrays.stream(ages).forEach(age -> ++ageCount[age]);
        for (int i = 15; i < ageCount.length; i++)
            if (ageCount[i] != 0) {
                for (int j = i / 2 + 8; j < i; j++) res += ageCount[i] * ageCount[j];
                res += ageCount[i] * (ageCount[i] - 1);
            }
        return res;
    }
}
