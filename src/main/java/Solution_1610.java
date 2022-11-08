package main.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution_1610 {
    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        int samePointNum = 0;
        List<Double> degrees = new ArrayList<>();
        int locX = location.get(0), locY = location.get(1);
        for (List<Integer> point : points) {
            int curX = point.get(0), curY = point.get(1);
            if (curX == locX && curY == locY) samePointNum++;
            else degrees.add(Math.atan2(curY - locY, curX - locX) / Math.PI * 180);
        }
        Collections.sort(degrees);
        int n = degrees.size();
        for (int i = 0; i < n && degrees.get(i) + 180 <= angle; i++)
            degrees.add(degrees.get(i) + 360);
        int res = 0;
        int left = 0, right = 0;
        while (right < degrees.size()) {
            right++;
            while (left < right && degrees.get(right - 1) - degrees.get(left) > angle)
                left++;
            res = Math.max(res, right - left);
        }
        return res + samePointNum;
    }
}
