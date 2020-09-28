package com.assignment;

import com.assignment.model.Cart;
import com.assignment.model.SKUItem;
import com.assignment.promotions.GroupedSKUItemsPromotion;
import com.assignment.promotions.MultipleItemsOfSingleSKUPromotion;
import com.assignment.promotions.Promotion;
import com.assignment.promotions.UnitPricePromotion;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PromotionEngine {

    public static void main(String[] args) {

        Map<SKUItem, Integer> skuItemsWithCount = new HashMap<>();

        skuItemsWithCount.put(SKUItem.A, 3);
        skuItemsWithCount.put(SKUItem.B, 5);
        skuItemsWithCount.put(SKUItem.C, 1);
        skuItemsWithCount.put(SKUItem.D, 1);

        // Cart with SKU items with their occurrence count.
        Cart cart = new Cart(skuItemsWithCount);

        Promotion promotion1 = new MultipleItemsOfSingleSKUPromotion(SKUItem.A, 3, 130);
        Promotion promotion2 = new MultipleItemsOfSingleSKUPromotion(SKUItem.B, 2, 45);
        Promotion promotion3 = new GroupedSKUItemsPromotion(SKUItem.C, SKUItem.D, 30);
        Promotion promotion4 = new UnitPricePromotion();

        List<Promotion> activePromotions = Arrays.asList(promotion1, promotion2, promotion3, promotion4);

        // Promotion chain having the list of promotions.
        PromotionChain promotionChain = new PromotionChain(activePromotions);

        //Apply the promotions to the sku items in the cart , to find the total order value.
        int totalOrderValue = promotionChain.evaluate(cart);

        System.out.println("Total Order Price : " + totalOrderValue);
    }
}
