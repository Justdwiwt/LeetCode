package main.java;

public class Solution_1899 {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        return check(triplets, target, 0) && check(triplets, target, 2) && check(triplets, target, 1);
    }

    private boolean check(int[][] triplets, int[] target, int k) {
        for (int[] triplet : triplets)
            if (triplet[k] == target[k] && triplet[(k + 1) % 3] <= target[(k + 1) % 3] && triplet[(k + 2) % 3] <= target[(k + 2) % 3])
                return true;
        return false;
    }
}
