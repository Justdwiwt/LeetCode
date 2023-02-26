package main.java;

public class Solution_1108 {
    public static String defangIPaddr(String address) {
        return address.replaceAll("\\.", "[.]");
    }
}
