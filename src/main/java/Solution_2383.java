package main.java;

public class Solution_2383 {
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int sum = 0;
        int ex = initialExperience;
        int max = 0;
        for (int i = 0; i < experience.length; i++) {
            max = Math.max(experience[i] - ex + 1, max);
            ex += experience[i];
            sum += energy[i];
        }
        return Math.max(0, Math.max(0, sum + 1 - initialEnergy) + max);
    }
}
