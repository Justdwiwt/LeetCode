package main.java;

public class Solution_1678 {
    public String interpret(String command) {
        return command.replace("()", "o").replace("(al)", "al");
    }
}
