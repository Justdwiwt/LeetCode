package main.java;

import java.util.stream.IntStream;

public class Solution_2409 {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int[] month = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] month_day = new int[13];
        IntStream.range(1, 13).forEach(i -> month_day[i] = month_day[i - 1] + month[i - 1]);
        String[] alice_a = arriveAlice.split("-");
        String[] alice_l = leaveAlice.split("-");
        String[] bob_a = arriveBob.split("-");
        String[] bob_l = leaveBob.split("-");
        int[] month_a = {Math.max(0, Integer.parseInt(alice_a[0]) - 1), Math.max(0, Integer.parseInt(alice_l[0]) - 1)};
        int[] month_b = {Math.max(0, Integer.parseInt(bob_a[0]) - 1), Math.max(0, Integer.parseInt(bob_l[0]) - 1)};
        int[] alice = {month_day[month_a[0]] + Integer.parseInt(alice_a[1]), month_day[month_a[1]] + Integer.parseInt(alice_l[1])};
        int[] bob = {month_day[month_b[0]] + Integer.parseInt(bob_a[1]), month_day[month_b[1]] + Integer.parseInt(bob_l[1])};
        int ans = Math.min(alice[1], bob[1]) - Math.max(alice[0], bob[0]);
        return ans < 0 ? 0 : ans + 1;
    }
}
