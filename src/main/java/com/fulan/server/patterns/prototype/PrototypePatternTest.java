package com.fulan.server.patterns.prototype;

public class PrototypePatternTest {
    public static void main(String[] args) {
        ShapeCache.loadCache();
        Shape circle = ShapeCache.getShape(1);
        System.out.println("Shape : " + circle.getType());
        Shape rectangle = ShapeCache.getShape(2);
        System.out.println("Shape : " + rectangle.getType());


    }
}
