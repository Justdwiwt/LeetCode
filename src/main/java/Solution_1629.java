package main.java;

public class Solution_1629 {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        char res = keysPressed.charAt(0);
        int mx = releaseTimes[0];
        for (int i = 1; i < releaseTimes.length; i++)
            if (releaseTimes[i] - releaseTimes[i - 1] == mx)
                res = res > keysPressed.charAt(i) ? res : keysPressed.charAt(i);
            else if (releaseTimes[i] - releaseTimes[i - 1] > mx) {
                res = keysPressed.charAt(i);
                mx = releaseTimes[i] - releaseTimes[i - 1];
            }
        return res;
    }
}
