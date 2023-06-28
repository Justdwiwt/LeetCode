package main.java;

public class Solution_679 {
    public boolean judgePoint24(int[] cards) {
        double[] l = new double[4];
        for (int i = 0; i < 4; i++) l[i] = cards[i];
        return f(l);
    }

    private boolean f(double[] l) {
        int n = l.length;
        if (n == 1) return Math.abs(l[0] - 24) < 1e-6;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (i != j) {
                    double[] t = new double[n - 1];
                    for (int k = 0, p = 0; k < n; k++)
                        if (k != i && k != j) {
                            t[p] = l[k];
                            p++;
                        }
                    for (int p = 0; p < 4; p++) {
                        if ((p < 2 && i > j) || (p == 3 && l[j] < 1e-6)) continue;
                        switch (p) {
                            case 0:
                                t[n - 2] = l[i] + l[j];
                                break;
                            case 1:
                                t[n - 2] = l[i] * l[j];
                                break;
                            case 2:
                                t[n - 2] = l[i] - l[j];
                                break;
                            case 3:
                                t[n - 2] = l[i] / l[j];
                                break;
                        }
                        if (f(t)) return true;
                    }
                }
        return false;
    }
}
