package com.promotion;

import java.util.List;

public class ShoppingCart {

    private List<Item> items;

    private ProductInventory productInventory;

    public <T> ShoppingCart(List<Item> items) {
        this.items = items;
        this.productInventory = new ProductInventory();
    }

    public double getTotal() {
        Double total = 0.00;
        for(Item item : items) {
            Double unitPrice = this.productInventory.getInventory().get(item.getItemName());
            if(unitPrice != null)
                total = unitPrice * item.getQuantity();
        }

        return total;
    }
}
