package main.java;

public class Solution_933 {
    int[] records;
    int head, tail;

    public void RecentCounter() {
        records = new int[10010];
        head = tail = 0;
    }

    public int ping(int t) {
        records[tail++] = t;
        while (head < tail && records[head] < t - 3000) {
            head++;
        }
        return tail - head;
    }
}
