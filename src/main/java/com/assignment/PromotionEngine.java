package com.assignment;

import com.assignment.model.Cart;
import com.assignment.model.SKUItem;
import com.assignment.promotions.Promotion;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PromotionEngine {

    public static void main(String[] args) {

        Map<SKUItem, Integer> skuItemsWithCount = new HashMap<>();

        skuItemsWithCount.put(SKUItem.A, 1);
        skuItemsWithCount.put(SKUItem.B, 1);
        skuItemsWithCount.put(SKUItem.C, 1);

        Cart cart = new Cart(skuItemsWithCount);

        List<Promotion> promotions = Arrays.asList();

        PromotionChain promotionChain = new PromotionChain(promotions);
        int totalOrderValue = promotionChain.evaluate(cart);

        System.out.println(totalOrderValue);
    }
}
