package main.java;

public class Solution_1643 {
    public String kthSmallestPath(int[] destination, int k) {
        int v = destination[0];
        int h = destination[1];
        if (v == 0) return new String(new char[h]).replace("\0", "H");
        if (h == 0) return new String(new char[v]).replace("\0", "V");

        int cnt = v + h;
        int comb = f(cnt - 1, h - 1);

        return k <= comb ? "H" + kthSmallestPath(new int[]{v, h - 1}, k) : "V" + kthSmallestPath(new int[]{v - 1, h}, k - comb);
    }

    private int f(int i, int j) {
        if (j == 0) return 1;
        return f(i - 1, j - 1) * i / j;
    }
}
