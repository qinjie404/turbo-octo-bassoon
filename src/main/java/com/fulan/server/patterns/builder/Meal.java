package com.fulan.server.patterns.builder;

import java.util.ArrayList;
import java.util.List;

public class Meal {
    private List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }

    public Double getCost() {
        Double cost = 0.0;
        for (Item i : items) {
            cost += i.price();
        }
        return cost;
    }

    public void showItems() {
        for (Item i : items) {
            System.out.print("Item:" + i.name());
            System.out.print(",Pack:" + i.packing().pack());
            System.out.println(",price:" + i.price());
        }

    }
}
