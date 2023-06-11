package main.java;

public class Solution_744 {
    public char nextGreatestLetter(char[] letters, char target) {
        int minDis = 0;
        for (char letter : letters) {
            int dis = (letter - target + 26) % 26;
            if (dis > 0) minDis = minDis == 0 ? dis : Math.min(minDis, dis);
        }
        return (char) ((target - 'a' + minDis) % 26 + 'a');
    }
}
