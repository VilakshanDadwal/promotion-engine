package com.assignment;

import com.assignment.model.Cart;
import com.assignment.model.SKUItem;
import com.assignment.promotions.Promotion;

import java.util.List;
import java.util.Map;

/**
 * Evaluates all the items in the card and returns the total order value.
 */

public class PromotionChain {

    List<Promotion> promotions;

    public PromotionChain(List<Promotion> promotions) {
        this.promotions = promotions;
    }

    public int evaluate(Cart cart) {
        int totalOrderValue = 0;

        // Using map to store the item and its occurrence count in the cart.
        Map<SKUItem, Integer> skuItemWithOccurrenceCount = cart.getSkuItemsWithCount();

        for (Promotion promotion : promotions) {
            totalOrderValue += promotion.apply(skuItemWithOccurrenceCount);
        }
        return totalOrderValue;
    }
}
