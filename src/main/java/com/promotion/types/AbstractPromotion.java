package com.promotion.types;

import com.promotion.ProductInventoryStore;

public abstract class AbstractPromotion implements PromotionI {

    protected ProductInventoryStore productInventoryStore;

    public AbstractPromotion() {
        this.productInventoryStore = new ProductInventoryStore();
    }
}
