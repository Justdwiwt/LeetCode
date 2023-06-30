package main.java;

public class Solution_672 {
    public int flipLights(int n, int presses) {
        return presses == 0 ? 1 : n == 1 ? 2 : n == 2 ? (presses == 1) ? 3 : 4 : (presses > 2) ? 8 : (presses == 1) ? 4 : 7;
    }
}
