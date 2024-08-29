package main.java;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class Solution_2307 {
    int[] fathers;
    double[] weights;

    public boolean checkContradictions(List<List<String>> equations, double[] values) {
        int n = equations.size();
        Map<String, Integer> var2idx = new HashMap<>();
        int varCount = 0;
        for (List<String> eq : equations) {
            if (!var2idx.containsKey(eq.get(0))) var2idx.put(eq.get(0), varCount++);
            if (!var2idx.containsKey(eq.get(1))) var2idx.put(eq.get(1), varCount++);
        }
        this.fathers = new int[varCount];
        this.weights = new double[varCount];
        IntStream.range(0, varCount).forEach(i -> {
            fathers[i] = i;
            weights[i] = 1.0;
        });
        for (int i = 0; i < n; i++) {
            List<String> q = equations.get(i);
            if (find(var2idx.get(q.get(0))) != find(var2idx.get(q.get(1))))
                union(var2idx.get(q.get(0)), var2idx.get(q.get(1)), values[i]);
            else if (Math.abs(query(var2idx.get(q.get(0)), var2idx.get(q.get(1))) - values[i]) >= 1e-5) return true;
        }
        return false;
    }

    public int find(int x) {
        if (fathers[x] != x) {
            int f = find(fathers[x]);
            weights[x] *= weights[fathers[x]];
            fathers[x] = f;
        }
        return fathers[x];
    }

    public void union(int x, int y, double v) {
        int xRoot = find(x);
        int yRoot = find(y);
        if (xRoot != yRoot) {
            fathers[xRoot] = yRoot;
            weights[xRoot] = v * weights[y] / weights[x];
        }
    }

    public double query(int x, int y) {
        return weights[x] / weights[y];
    }
}
