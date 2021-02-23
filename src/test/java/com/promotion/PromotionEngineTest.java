package com.promotion;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PromotionEngineTest {

    @Test
    public void totalOfEmptyCart(){
        ShoppingCart cart = new ShoppingCart(new ArrayList<>());
        assertEquals(0.0, cart.getTotal());
    }

    @Test
    public void totalOfSingleItemCart() {
        ShoppingCart cart = new ShoppingCart(Arrays.asList(new Item("A", 2)));
        assertEquals(100.0, cart.getTotal());
    }
}
