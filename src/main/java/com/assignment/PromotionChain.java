package com.assignment;

import com.assignment.promotions.Promotion;

import java.util.List;

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
        for (Promotion promotion : promotions) {
            totalOrderValue += promotion.apply(cart.getSkuItems());
        }
        return totalOrderValue;
    }
}
