package com.assignment.promotions;

import com.assignment.model.SKUItem;

import java.util.Map;

/**
 * It is applied in the end after applying all other promotions.
 * This is basic promotion to calculate price as per the unit price
 * of the sku items.
 */

public class UnitPricePromotion implements Promotion {
    @Override
    public int apply(Map<SKUItem, Integer> skuItems) {

        return skuItems.entrySet()
                .stream()
                .mapToInt(entry -> ((SKUItem) entry.getKey()).getUnitPrice() * entry.getValue())
                .sum();
    }
}
