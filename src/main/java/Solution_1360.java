package main.java;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Solution_1360 {
    public int daysBetweenDates(String date1, String date2) {
        return (int) Math.abs(LocalDate.parse(date1).until(LocalDate.parse(date2), ChronoUnit.DAYS));
    }
}
