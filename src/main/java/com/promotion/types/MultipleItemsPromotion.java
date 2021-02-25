package com.promotion.types;

import com.promotion.dto.Item;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.keyvalue.MultiKey;
import org.apache.commons.collections4.map.MultiKeyMap;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class MultipleItemsPromotion extends AbstractPromotion {

    private final MultiKeyMap multiPromotionMap = new MultiKeyMap();

    public MultipleItemsPromotion() {
        multiPromotionMap.put("C", "D", 30.00);
    }

    @Override
    public Double calculate(List<Item> items) {
        AtomicReference<Double> total = new AtomicReference<>(0.00);
        MapIterator iterator = multiPromotionMap.mapIterator();
        while (iterator.hasNext()) {
            iterator.next();
            MultiKey mk = (MultiKey) iterator.getKey();
            String productNameKey1 = (String) mk.getKey(0);
            String productNameKey2 = (String) mk.getKey(1);
            Double promotionPrice = (Double) iterator.getValue();
            Integer product1Qty = 0, product2Qty = 0;
            String productName1 = "", productName2 = "";
            for (Item item : items) {
                if (item.getItemName().equals(productNameKey1)) {
                    product1Qty = item.getQuantity();
                    productName1 = item.getItemName();
                } else if (item.getItemName().equals(productNameKey2)) {
                    product2Qty = item.getQuantity();
                    productName2 = item.getItemName();
                }
            }

            if (product1Qty > 0 && product2Qty > 0) {
                total.set(calculatePrice(product1Qty, product2Qty, promotionPrice, productName1, productName2, items) + total.get());
            }
        }

        return total.get();
    }

    private Double calculatePrice(Integer product1Qty, Integer product2Qty, Double promotionPrice, String productName1, String productName2, List<Item> items) {
        if (product1Qty == product2Qty) {
            getItem(productName1, items).setQuantity(product1Qty - product2Qty);
            getItem(productName2, items).setQuantity(product2Qty - product1Qty);
            return product1Qty * promotionPrice;
        } else if (product1Qty > product2Qty) {
            getItem(productName1, items).setQuantity(product1Qty - product2Qty);
            return product2Qty * promotionPrice;
        } else if (product2Qty > product1Qty) {
            getItem(productName2, items).setQuantity(product2Qty - product1Qty);
            return product1Qty * promotionPrice;
        }
        return 0.00;
    }

    private Item getItem(String productName, List<Item> items) {
        return items.stream()
                .filter(e -> e.getItemName().equals(productName))
                .findAny()
                .orElse(null);
    }
}
