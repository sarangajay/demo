package com.promotion;

public class ProductCostCalculator {

    private final ProductInventory productInventory;

    public ProductCostCalculator(ProductInventory productInventory) {
        this.productInventory = productInventory;
    }

    public Double calculateProductCost(Item item, Double total) {
        Double unitPrice = this.productInventory.getInventory().get(item.getItemName());
        if (unitPrice != null)
            return total + unitPrice * item.getQuantity();
        return total;
    }
}
