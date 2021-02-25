package com.promotion.types;

import com.promotion.dto.Item;

import java.util.List;

public interface PromotionI {
     Double calculate(List<Item> items);
}
