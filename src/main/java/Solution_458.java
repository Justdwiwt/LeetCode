package main.java;

public class Solution_458 {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int times = minutesToTest / minutesToDie + 1;
        int i = 0;
        int number = 1;
        while (number < buckets) {
            number *= times;
            i++;
        }
        return i;
    }
}
