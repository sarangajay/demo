package com.promotion.dto;

public class PromotionData {

    private final String name;
    private final Integer quantity;
    private final Double amount;

    public PromotionData(String name, Integer quantity, Double amount) {
        this.name = name;
        this.quantity = quantity;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Double getAmount() {
        return amount;
    }
}
