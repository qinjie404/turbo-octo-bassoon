package com.fulan.server.patterns.facade;

public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("draw a circle");
    }
}
