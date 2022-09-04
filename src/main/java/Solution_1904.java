package main.java;

public class Solution_1904 {
    public int numberOfRounds(String startTime, String finishTime) {
        int stHour = Integer.parseInt(startTime.substring(0, 2));
        int edHour = Integer.parseInt(finishTime.substring(0, 2));
        int stMinute = Integer.parseInt(startTime.substring(3, 5));
        int edMinute = Integer.parseInt(finishTime.substring(3, 5));
        int res = 0;
        if (stHour > edHour || stHour == edHour && stMinute > edMinute)
            res += (23 - stHour + edHour) * 4;
        else res += (edHour - stHour - 1) * 4;
        res += (60 - stMinute) / 15;
        res += edMinute / 15;
        return Math.max(res, 0);
    }
}
