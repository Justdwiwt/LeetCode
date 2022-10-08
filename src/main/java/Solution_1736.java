package main.java;

import java.util.stream.IntStream;

public class Solution_1736 {
    public String maximumTime(String time) {
        char[] times = new char[4];
        IntStream.range(0, 4).forEach(i -> times[i] = time.charAt(i < 2 ? i : i + 1));
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            if (times[i] == '?') switch (i) {
                case 0:
                    times[0] = times[1] >= '4' && times[1] <= '9' ? '1' : '2';
                    break;
                case 1:
                    times[1] = times[0] == '2' ? '3' : '9';
                    break;
                case 2:
                    times[2] = '5';
                    break;
                case 3:
                    times[3] = '9';
                    break;
            }
            res.append(times[i]);
            if (i == 1) res.append(":");
        }
        return res.toString();
    }
}
