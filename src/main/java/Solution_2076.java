package main.java;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.IntStream;

public class Solution_2076 {
    public boolean[] friendRequests(int n, int[][] restrictions, int[][] requests) {
        DSU dsu = new DSU(n, restrictions);
        int r = requests.length;
        boolean[] res = new boolean[r];
        IntStream.range(0, r).forEach(i -> {
            int[] req = requests[i];
            res[i] = dsu.union(req[0], req[1]);
        });
        return res;
    }

    static class DSU {

        Map<Integer, Set<Integer>> cmpToNodes = new HashMap<>();
        int[] parent;
        int[][] restrictions;

        DSU(int n, int[][] restrictions) {
            parent = new int[n];
            IntStream.range(0, n).forEach(i -> {
                Set<Integer> s = new HashSet<>();
                s.add(i);
                cmpToNodes.put(i, s);
                parent[i] = i;
            });
            this.restrictions = restrictions;
        }

        int find(int u) {
            if (u == parent[u]) return u;
            return parent[u] = find(parent[u]);
        }

        boolean union(int u, int v) {
            int pu = find(u);
            int pv = find(v);

            if (pu != pv) {
                Set<Integer> setU = cmpToNodes.get(pu);
                Set<Integer> setV = cmpToNodes.get(pv);
                for (int[] restrict : restrictions) {
                    int x = restrict[0];
                    int y = restrict[1];
                    boolean foundX = setU.contains(x) || setV.contains(x);
                    boolean foundY = setU.contains(y) || setV.contains(y);
                    if (foundX && foundY) return false;
                }
                setV.addAll(setU);
                parent[pu] = parent[pv];
            }
            return true;
        }
    }
}
