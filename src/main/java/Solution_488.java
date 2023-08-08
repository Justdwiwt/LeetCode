package main.java;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution_488 {
    public int findMinStep(String board, String hand) {
        Queue<String[]> q = new LinkedList<>();
        int step = 0;
        Set<String> set = new HashSet<>();
        q.add(new String[]{board, hand});
        while (!q.isEmpty()) {
            int sz = q.size();
            for (int t = 0; t < sz; t++) {
                String[] cur = q.poll();
                assert cur != null;
                String curBoard = cur[0];
                String curHand = cur[1];
                for (int i = 0; i < curBoard.length(); i++)
                    for (int j = 0; j < curHand.length(); j++) {
                        boolean ok = curBoard.charAt(i) == curHand.charAt(j);
                        if (i > 0 && curBoard.charAt(i - 1) == curBoard.charAt(i) && curBoard.charAt(i - 1) != curHand.charAt(j))
                            ok = true;
                        if (ok) {
                            StringBuilder sb = new StringBuilder(curBoard).insert(i, curHand.charAt(j));
                            removeSame(sb, i);
                            String newBoard = sb.toString();
                            if (newBoard.length() == 0) return step + 1;
                            if (!set.contains(newBoard)) {
                                String newHand = new StringBuilder(curHand).deleteCharAt(j).toString();
                                set.add(newBoard);
                                q.add(new String[]{newBoard, newHand});
                            }
                        }
                    }
            }
            step++;
        }
        return -1;
    }

    void removeSame(StringBuilder sb, int index) {
        if (index < 0) return;
        int l = index, r = index;
        char c = sb.charAt(index);
        while (l >= 0 && sb.charAt(l) == c) l--;
        while (r <= sb.length() - 1 && sb.charAt(r) == c) r++;
        int cnt = r - l - 1;
        if (cnt >= 3) {
            sb.delete(l + 1, r);
            removeSame(sb, l);
        }
    }
}
