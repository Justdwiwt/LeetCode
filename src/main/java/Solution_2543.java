package main.java;

public class Solution_2543 {
    public boolean isReachable(int targetX, int targetY) {
        while (true) {
            if (targetX % 2 == 0) targetX /= 2;
            else if (targetY % 2 == 0) targetY /= 2;
            else if (targetX != targetY) {
                if (targetY > targetX) targetY = (targetY + targetX) / 2;
                else targetX = (targetX + targetY) / 2;
            } else break;
        }
        return targetX == 1;
    }
}
