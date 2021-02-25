package com.promotion;

import com.promotion.dto.Item;
import com.promotion.types.PromotionI;
import org.reflections.Reflections;

import java.lang.reflect.Modifier;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Shopping cart that takes the user inputs and run through all the promotions available
 */
public class ShoppingCart {

    private List<Item> items;

    private ProductCostCalculator productCostCalculator;

    public ShoppingCart(List<Item> items) {
        this.items = items;
        this.productCostCalculator = new ProductCostCalculator(new ProductInventoryStore());
    }

    public double calculateTotal() {
        AtomicReference<Double> total = new AtomicReference<>(0.00);
        Reflections reflections = new Reflections("com.promotion.types");
        Set<Class<? extends PromotionI>> subTypes = reflections.getSubTypesOf(PromotionI.class);
        for(Class<? extends PromotionI> curClass : subTypes) {
            try {
                if(!Modifier.isAbstract(curClass.getModifiers())) {
                    PromotionI promotionService = curClass.newInstance();
                    total.set(promotionService.calculate(this.items) + total.get());               }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        total.set(getTotal() + total.get());
        return total.get();
    }

    private double getTotal() {
        AtomicReference<Double> total = new AtomicReference<>(0.00);
        items.stream().forEach(
                e -> {
                    total.set(this.productCostCalculator.calculateProductCost(e, total.get()));
                }
        );
        return total.get();
    }
}
