package com.promotion;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class ShoppingCart {

    private List<Item> items;

    private ProductCostCalculator productCostCalculator;

    public ShoppingCart(List<Item> items) {
        this.items = items;
        this.productCostCalculator = new ProductCostCalculator(new ProductInventory());
    }

    public double getTotal() {
        AtomicReference<Double> total = new AtomicReference<>(0.00);
        items.stream().forEach(
                e -> {
                    total.set(this.productCostCalculator.calculateProductCost(e, total.get()));
                }
        );
        return total.get();
    }
}
