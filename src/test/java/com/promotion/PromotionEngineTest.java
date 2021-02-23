package com.promotion;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PromotionEngineTest {

    @Test
    public void totalOfEmptyCart(){
        ShoppingCart cart = new ShoppingCart();
        assertEquals(0.0, cart.getTotal());
    }

    @Test
    public void totalOfSingleItemCart() {
        ShoppingCart cart = new ShoppingCart(Arrays.asList(new Item()));
    }
}
