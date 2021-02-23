package com.promotion;

import java.util.HashMap;
import java.util.Map;

public class ProductInventory {

    private final Map inventory = new HashMap<String, Double>();

    public ProductInventory() {
        this.inventory.put("A",50.00);
        this.inventory.put("B",30.00);
        this.inventory.put("C",20.00);
        this.inventory.put("D",15.00);
    }

    public Map<String, Double> getInventory() {
        return inventory;
    }
}
