package main.java;

public class Solution_1694 {
    public String reformatNumber(String number) {
        number = number.replace(" ", "");
        number = number.replace("-", "");
        number = number.replaceAll("(?<=\\G\\d{3})(?!$)", "-");
        number = number.replaceAll("\\b(\\d{2})(\\d+)-(\\d)$", "$1-$2$3");
        return number;
    }
}
