package com.fulan.server.patterns.builder;

public class VegBurger extends Burger {
    @Override
    public String name() {
        return "Veg Burger";
    }

    @Override
    public Double price() {
        return 25.0;
    }
}
