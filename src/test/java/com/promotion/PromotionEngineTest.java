package com.promotion;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PromotionEngineTest {

    @Test
    public void totalOfEmptyCart(){
        ShoppingCart cart = buildCartWithItems();
        assertEquals(0.0, cart.getTotal());
    }

    @Test
    public void totalOfSingleItemCart() {
        ShoppingCart cart = buildCartWithItems(new Item("A", 2));
        assertEquals(100.0, cart.getTotal());
    }

    @Test
    public void totalOfMultipleSingleItemCart() {
        ShoppingCart cart = buildCartWithItems(
                new Item("A", 1),
                new Item("B", 1),
                new Item("C", 1));
        assertEquals(100.0, cart.getTotal());
    }

    @Test
    public void totalOfSingleItemPromotion(){
        ShoppingCart cart = buildCartWithItems(new Item("A", 3));
        assertEquals(130.0, cart.getTotal());
    }

    private ShoppingCart buildCartWithItems(Item... items) {
        return new ShoppingCart(Arrays.asList(items));
    }
}
