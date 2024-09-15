package main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_2326 {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        List<Integer> list = new ArrayList<>(m * n);
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int[][] res = new int[m][n];
        Arrays.stream(res).forEach(re -> Arrays.fill(re, -1));
        int xMax = n - 1;
        int yMax = m - 1;
        int xStart = 0, yStart = 0;
        while (xStart <= xMax && yStart <= yMax) {
            for (int i = xStart; i <= xMax; i++)
                res[yStart][i] = list.isEmpty() ? -1 : list.remove(0);
            yStart++;
            for (int i = yStart; i <= yMax; i++)
                res[i][xMax] = list.isEmpty() ? -1 : list.remove(0);
            xMax--;
            for (int i = xMax; i >= xStart && yStart <= yMax; i--)
                res[yMax][i] = list.isEmpty() ? -1 : list.remove(0);
            yMax--;
            for (int i = yMax; i >= yStart && xStart <= xMax; i--)
                res[i][xStart] = list.isEmpty() ? -1 : list.remove(0);
            xStart++;
        }
        return res;
    }
}
