package main.java;

public class Solution_470 {
    public int rand7() {
        return 0;
    }

    public int rand10() {
        int x = ~(1 << 31);
        while (x > 40) x = 7 * (rand7() - 1) + rand7();
        return x % 10 + 1;
    }
}
