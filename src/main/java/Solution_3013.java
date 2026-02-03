package main.java;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class Solution_3013 {
    private static final int MAXN = (int) 1e5 + 10;
    private static final boolean[] inQ = new boolean[MAXN];
    private static final boolean[] del = new boolean[MAXN];

    public long minimumCost(int[] nums, int k, int dist) {
        long ans = Long.MAX_VALUE / 2;
        int n = nums.length;
        PriorityQueue<Integer> q1 = new PriorityQueue<>((o1, o2) -> Integer.compare(nums[o2], nums[o1]));
        PriorityQueue<Integer> q2 = new PriorityQueue<>(Comparator.comparingInt(o -> nums[o]));
        IntStream.range(0, n).forEach(i -> inQ[i] = del[i] = false);

        int size = 0;
        long sum = 0;
        k--;
        for (int i = 1; i < n; i++) {
            if (i - dist - 1 >= 1) {
                if (!del[i - dist - 1]) {
                    del[i - dist - 1] = true;
                    if (inQ[i - dist - 1]) {
                        size--;
                        sum -= nums[i - dist - 1];
                    }
                }
            }

            while (!q1.isEmpty() && del[q1.peek()]) q1.poll();

            if (q1.isEmpty() || nums[i] < nums[q1.peek()]) {
                q1.offer(i);
                inQ[i] = true;
                size++;
                sum += nums[i];
            } else q2.offer(i);

            while (size < k && !q2.isEmpty()) {
                int poll = q2.poll();
                if (!del[poll]) {
                    q1.offer(poll);
                    inQ[poll] = true;
                    size++;
                    sum += nums[poll];
                }
            }

            while (size > k && !q1.isEmpty()) {
                int poll = q1.poll();
                if (!del[poll]) {
                    q2.offer(poll);
                    inQ[poll] = false;
                    size--;
                    sum -= nums[poll];
                }
            }

            if (size == k) ans = Math.min(ans, sum);
        }

        ans += nums[0];
        return ans;
    }
}
