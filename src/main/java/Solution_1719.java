package main.java;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class Solution_1719 {
    public int checkWays(int[][] pairs) {
        Set<Integer>[] path = IntStream.range(0, 505).<Set<Integer>>mapToObj(i -> new HashSet<>()).toArray(Set[]::new);
        int numOfNodes = 0;
        int mostRelations = 0;
        for (int[] pair : pairs) {
            if (path[pair[0]].size() == 0) numOfNodes++;
            if (path[pair[1]].size() == 0) numOfNodes++;
            path[pair[0]].add(pair[1]);
            path[pair[1]].add(pair[0]);
            mostRelations = Math.max(mostRelations, Math.max(path[pair[0]].size(), path[pair[1]].size()));
        }
        if (numOfNodes != mostRelations + 1) return 0;
        int rootVal;
        int res = 1;
        for (int i = 1; ; i++)
            if (path[i].size() == mostRelations) {
                rootVal = i;
                break;
            }
        for (int p : path[rootVal]) {

            int dad = -1, partnerNum = 505;
            for (int partner : path[p]) {
                if (rootVal == p) continue;
                if (partnerNum > path[partner].size() && path[partner].size() >= path[p].size()) {
                    dad = partner;
                    partnerNum = path[partner].size();
                }
            }
            if (partnerNum == path[p].size()) res = 2;
            for (int a : path[p]) {
                if (a == dad) continue;
                if (!path[dad].contains(a)) return 0;
            }
        }
        return res;
    }
}
