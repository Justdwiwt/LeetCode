package main.java;

public class Solution_1884 {
    public int twoEggDrop(int n) {
        return (int) Math.ceil(Math.sqrt(n * 2 - 0.25) - 0.5);
    }
}
