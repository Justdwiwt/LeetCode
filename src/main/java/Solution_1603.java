package main.java;

public class Solution_1603 {
    static class ParkingSystem {
        private int[] parking;

        public ParkingSystem(int big, int medium, int small) {
            parking = new int[]{0, big, medium, small};
        }

        public boolean addCar(int carType) {
            if (parking[carType] > 0) {
                parking[carType]--;
                return true;
            }
            return false;
        }
    }
}
