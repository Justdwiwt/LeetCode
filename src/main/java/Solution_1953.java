package main.java;

public class Solution_1953 {
    public long numberOfWeeks(int[] milestones) {
        long sum = 0, max = 0;
        for (int milestone : milestones) {
            sum += milestone;
            max = Math.max(max, milestone);
        }
        long sumWithoutMax = sum - max;
        return sumWithoutMax < max ? 2 * sumWithoutMax + 1 : sum;
    }
}
