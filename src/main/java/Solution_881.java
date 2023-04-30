package main.java;

import java.util.Arrays;

public class Solution_881 {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int n = people.length;
        int i = 0, j = n - 1;
        while (i < j) {
            if (people[j] + people[i] <= limit) i++;
            j--;
        }
        return n - i;
    }
}
