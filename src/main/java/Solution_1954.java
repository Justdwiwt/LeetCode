package main.java;

public class Solution_1954 {
    public long minimumPerimeter(long neededApples) {
        long len = 0;
        for (; neededApples > 0; len += 2)
            neededApples -= 3 * len * len;
        return (len - 2) * 4;
    }
}
