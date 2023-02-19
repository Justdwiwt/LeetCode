package main.java;

public class Solution_1154 {
    public int dayOfYear(String date) {
        String[] arr = date.split("-");
        int year = Integer.parseInt(arr[0]), month = Integer.parseInt(arr[1]), day = Integer.parseInt(arr[2]);
        java.util.GregorianCalendar cal = new java.util.GregorianCalendar(year, month - 1, day);
        return cal.get(java.util.Calendar.DAY_OF_YEAR);
    }
}
