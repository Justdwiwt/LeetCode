package main.java;

public class Solution_1472 {
    static class BrowserHistory {
        int index = -1;
        int end = -1;
        String[] history = new String[101];

        public BrowserHistory(String homepage) {
            history[++index] = homepage;
            end++;
        }

        public void visit(String url) {
            history[++index] = url;
            end = index;
        }

        public String back(int steps) {
            index = index > steps ? index - steps : 0;
            return history[index];
        }

        public String forward(int steps) {
            index = Math.min(index + steps, end);
            return history[index];
        }
    }
}
