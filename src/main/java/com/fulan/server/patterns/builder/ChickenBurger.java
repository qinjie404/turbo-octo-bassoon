package com.fulan.server.patterns.builder;

public class ChickenBurger extends Burger {
    @Override
    public String name() {
        return "Chicken Burger";
    }

    @Override
    public Double price() {
        return 50.0;
    }
}
