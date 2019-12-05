package com.fulan.server.patterns.builder;

public class MealBuilder {
    public static Meal prepareVegMeal() {
        Meal vegMeal = new Meal();
        vegMeal.addItem(new VegBurger());
        vegMeal.addItem(new Coke());
        return vegMeal;
    }

    public static Meal prepareChickenMeal() {
        Meal chickenMeal = new Meal();
        chickenMeal.addItem(new ChickenBurger());
        chickenMeal.addItem(new Pepsi());
        return chickenMeal;
    }
}
