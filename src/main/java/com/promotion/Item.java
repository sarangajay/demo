package com.promotion;

public class Item  {
    private String itemName;
    private Integer quantity;

    public Item(String itemName, Integer quantity) {
        this.itemName = itemName;
        this.quantity = quantity;
    }

    public String getItemName() {
        return itemName;
    }

    public Integer getQuantity() {
        return quantity;
    }
}
