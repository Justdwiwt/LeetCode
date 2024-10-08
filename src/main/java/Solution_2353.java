package main.java;

import java.util.HashMap;
import java.util.TreeSet;
import java.util.stream.IntStream;

public class Solution_2353 {
    static class FoodRatings {
        private static class Food implements Comparable<Food> {
            String name;
            String cuisine;
            int rating;

            Food(String name, String cuisine, int rating) {
                this.name = name;
                this.cuisine = cuisine;
                this.rating = rating;
            }

            @Override
            public int compareTo(Food b) {
                return this.rating != b.rating ? b.rating - this.rating : this.name.compareTo(b.name);
            }
        }

        HashMap<String, Food> nameToFood = new HashMap<>();
        HashMap<String, TreeSet<Food>> cuisineToFoodSet = new HashMap<>();

        public FoodRatings(String[] names, String[] cuisines, int[] ratings) {
            IntStream.range(0, names.length).forEach(i -> {
                Food food = new Food(names[i], cuisines[i], ratings[i]);
                nameToFood.put(names[i], food);
                cuisineToFoodSet.computeIfAbsent(cuisines[i], key -> new TreeSet<>()).add(food);
            });
        }

        public void changeRating(String name, int newRating) {
            Food oldFood = nameToFood.get(name);
            Food newFood = new Food(name, oldFood.cuisine, newRating);
            nameToFood.put(name, newFood);
            cuisineToFoodSet.get(oldFood.cuisine).remove(oldFood);
            cuisineToFoodSet.get(oldFood.cuisine).add(newFood);
        }

        public String highestRated(String cuisine) {
            return cuisineToFoodSet.get(cuisine).first().name;
        }
    }
}
