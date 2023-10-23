package main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_354 {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (o1, o2) -> o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0]);
        List<Integer> list = new ArrayList<>();
        list.add(envelopes[0][1]);
        for (int[] envelope : envelopes)
            if (envelope[1] > list.get(list.size() - 1)) list.add(envelope[1]);
            else {
                int start = 0, end = list.size() - 1;
                int idx = 0;
                while (start <= end) {
                    int mid = (start + end) >>> 1;
                    if (list.get(mid) >= envelope[1]) {
                        idx = mid;
                        end = mid - 1;
                    } else start = mid + 1;
                }
                list.set(idx, envelope[1]);
            }
        return list.size();
    }
}
