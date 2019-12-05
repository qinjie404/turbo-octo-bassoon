package com.fulan.server.patterns.builder;

public class BuilderPatternTest {
    public static void main(String[] args) {
        Meal vegMeal=MealBuilder.prepareVegMeal();
        System.out.println("VegMeal:");
        vegMeal.showItems();
        System.out.println("Total cost:"+vegMeal.getCost());

        System.out.println("*********************************");
        Meal chickenMeal=MealBuilder.prepareChickenMeal();
        System.out.println("ChickenMeal:");
        chickenMeal.showItems();
        System.out.println("Total cost:"+chickenMeal.getCost());

    }
}
