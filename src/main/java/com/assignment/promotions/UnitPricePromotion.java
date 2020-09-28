package com.assignment.promotions;

import com.assignment.model.SKUItem;

import java.util.Map;

public class UnitPricePromotion implements Promotion {
    @Override
    public int apply(Map<SKUItem, Integer> skuItems) {

        return skuItems.entrySet()
                .stream()
                .mapToInt(entry -> ((SKUItem)entry.getKey()).getUnitPrice() * entry.getValue())
                .sum();
    }
}
