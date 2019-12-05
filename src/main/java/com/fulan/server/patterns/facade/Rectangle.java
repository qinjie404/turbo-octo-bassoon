package com.fulan.server.patterns.facade;

public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("draw a rectangle");
    }
}
