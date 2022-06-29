package main.java;

public class Solution_2201 {
    public int digArtifacts(int n, int[][] artifacts, int[][] dig) {
        int res = 0;
        boolean[][] visited = new boolean[n][n];
        for (int[] d : dig) visited[d[0]][d[1]] = true;
        for (int[] artifact : artifacts) {
            boolean flag = true;
            for (int row = artifact[0]; row <= artifact[2] && flag; row++)
                for (int col = artifact[1]; col <= artifact[3] && flag; col++)
                    flag = visited[row][col];
            if (flag) res++;
        }
        return res;
    }
}
