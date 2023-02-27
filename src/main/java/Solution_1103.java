package main.java;

public class Solution_1103 {
    public int[] distributeCandies(int candies, int num_people) {
        int cur = 0;
        int[] res = new int[num_people];
        while (candies > 0) {
            res[cur % num_people] += Math.min(++cur, candies);
            candies -= cur;
        }
        return res;
    }
}
