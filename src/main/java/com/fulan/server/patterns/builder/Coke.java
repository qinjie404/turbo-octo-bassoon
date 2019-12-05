package com.fulan.server.patterns.builder;

public class Coke extends ColdDrink {
    @Override
    public String name() {
        return "Coke";
    }

    @Override
    public Double price() {
        return 10.0;
    }
}
