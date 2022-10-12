package main.java;

public class Solution_1718 {
    public int[] constructDistancedSequence(int n) {
        int[] ret = new int[2 * n - 1];
        dfs(0, ret, n, 0);
        return ret;
    }

    private boolean dfs(int idx, int[] ret, int n, int nState) {
        if (idx == ret.length) return true;
        if (ret[idx] != 0) return dfs(idx + 1, ret, n, nState);

        for (int i = n; i > 1; i--)
            if ((nState & (1 << i)) == 0 && idx + i < ret.length && ret[idx + i] == 0) {
                ret[idx] = i;
                ret[idx + i] = i;
                if (dfs(idx + 1, ret, n, nState | (1 << i))) return true;
                ret[idx] = 0;
                ret[idx + i] = 0;
            }
        if ((nState & (1 << 1)) == 0) {
            ret[idx] = 1;
            if (dfs(idx + 1, ret, n, nState | (1 << 1))) return true;
            ret[idx] = 0;
        }
        return false;
    }
}
