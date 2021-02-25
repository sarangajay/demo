package com.promotion;

import com.promotion.dto.Item;

public class ProductCostCalculator {

    private final ProductInventoryStore productInventoryStore;

    public ProductCostCalculator(ProductInventoryStore productInventoryStore) {
        this.productInventoryStore = productInventoryStore;
    }

    public Double calculateProductCost(Item item, Double total) {
        Double unitPrice = this.productInventoryStore.getInventory().get(item.getItemName());
        if (unitPrice != null)
            return total + unitPrice * item.getQuantity();
        return total;
    }
}
