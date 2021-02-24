package com.promotion;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

public class SingleItemPromotion extends AbstractPromotion {

    private final Map<String, PromotionData> promotionDataMap = new HashMap();

    public SingleItemPromotion() {
        promotionDataMap.put("A", new PromotionData("A", 3, 130.00));
        promotionDataMap.put("B", new PromotionData("B", 2, 45.00));
    }

    @Override
    public Double calculate(List<Item> items) {
        AtomicReference<Double> total = new AtomicReference<>(0.00);
        for (Item item : items) {
            if (item.isProcessed())
                continue;
            PromotionData promotionData = promotionDataMap.get(item.getItemName());
            if (promotionData != null) {
                Integer promoQty = coveredByPromotion(item.getQuantity(), promotionData.getQuantity());
                total.set(totalPromotionValue(promoQty, promotionData.getAmount()) + total.get());
                item.setQuantity(item.getQuantity() - (promoQty * promotionData.getQuantity()));
                item.setProcessed(true);
            }
        }
        return total.get();
    }

    private Integer coveredByPromotion(Integer itemQty, Integer promotionQty) {
        Integer quotient = itemQty / promotionQty;
        return quotient;
    }

    private Double totalPromotionValue(Integer promotionCount, Double promotionValue) {
        if (promotionCount == 0)
            return 0.00;

        Double value = promotionCount * promotionValue;
        return value;
    }

}
