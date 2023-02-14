package main.java;

import java.time.LocalDate;

public class Solution_1185 {
    public static String dayOfTheWeek(int day, int month, int year) {
        String[] week = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        return week[LocalDate.of(year, month, day).getDayOfWeek().getValue() - 1];
    }
}
