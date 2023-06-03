package main.java;

public class Solution_777 {
    public boolean canTransform(String start, String end) {
        int i = 0;
        int j = 0;
        int n = start.length();
        while (true) {
            while (i < n && start.charAt(i) == 'X') i++;
            while (j < n && end.charAt(j) == 'X') j++;
            if (i == n || j == n) break;
            if (start.charAt(i) != end.charAt(j)) return false;
            else {
                if (start.charAt(i) == 'L' && i < j) return false;
                if (start.charAt(i) == 'R' && i > j) return false;
                i++;
                j++;
            }
        }
        return i == n && j == n;
    }
}
