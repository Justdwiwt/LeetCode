package main.java;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Solution_1964 {
    public int[] longestObstacleCourseAtEachPosition(int[] obst) {
        int[] res = new int[obst.length];
        List<Integer> list = new ArrayList<>();
        IntStream.range(0, obst.length).forEach(i -> {
            if (i == 0 || obst[i] >= list.get(list.size() - 1)) {
                list.add(obst[i]);
                res[i] = list.size();
            } else {
                int j = findLargerIndex(list, obst[i]);
                list.set(j, obst[i]);
                res[i] = j + 1;
            }
        });
        return res;
    }

    private int findLargerIndex(List<Integer> list, int target) {
        int l = 0, r = list.size() - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (list.get(mid) > target) r = mid - 1;
            else if (list.get(mid) < target) l = mid + 1;
            else {
                if (mid == r || list.get(mid + 1) != target) return mid + 1;
                else l = mid + 1;
            }
        }
        return l;
    }
}
