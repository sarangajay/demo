package com.promotion;

public abstract class AbstractPromotion implements PromotionI {

    protected ProductInventory productInventory;

    public AbstractPromotion() {
        this.productInventory = new ProductInventory();
    }
}
