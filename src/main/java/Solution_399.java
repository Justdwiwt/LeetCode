package main.java;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class Solution_399 {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int N = queries.size();
        double[] res = new double[N];
        Map<String, Integer> indexMap = new HashMap<>();
        int idx = 0;
        for (List<String> equation : equations) {
            if (!indexMap.containsKey(equation.get(0))) indexMap.put(equation.get(0), idx++);
            if (!indexMap.containsKey(equation.get(1))) indexMap.put(equation.get(1), idx++);
        }
        int M = indexMap.size();
        double[][] graph = new double[M][M];
        for (int i = 0; i < M; i++)
            for (int j = 0; j < M; j++)
                graph[i][j] = i == j ? 1.0 : -1.0;
        IntStream.range(0, values.length).forEach(i -> {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            graph[indexMap.get(a)][indexMap.get(b)] = values[i];
            graph[indexMap.get(b)][indexMap.get(a)] = 1 / values[i];
        });
        IntStream.range(0, N).forEach(i -> {
            String a = queries.get(i).get(0);
            String b = queries.get(i).get(1);
            if (!indexMap.containsKey(a) || !indexMap.containsKey(b)) {
                res[i] = -1.0;
                return;
            }
            double[] doubles = calculate(indexMap.get(a), indexMap.get(b), new boolean[M], graph);
            graph[indexMap.get(a)][indexMap.get(b)] = doubles[0];
            res[i] = doubles[0];
        });
        return res;
    }

    public double[] calculate(int a, int b, boolean[] used, double[][] graph) {
        used[a] = true;
        if (graph[a][b] != -1.0) return new double[]{graph[a][b], 1.0};
        for (int i = 0; i < graph.length; i++)
            if (!used[i] && graph[a][i] != -1.0) {
                double[] res = calculate(i, b, used, graph);
                if (res[1] == 1.0) return new double[]{res[0] * graph[a][i], 1.0};
                used[i] = false;
            }
        return new double[]{-1.0, 0.0};
    }
}
