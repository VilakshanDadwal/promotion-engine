package com.assignment.promotions;


import com.assignment.model.SKUItem;

import java.util.Map;

/**
 * Buy n items of a SKU for a fixed prime promotion
 * skuItem is the item on which the promotion is to be applied
 * requiredNoOfItems is the total number of items required for the promotion to be applied
 * fixedPrice is the value to return if the promotion is applicable.
 */
public class MultipleItemsOfSingleSKUPromotion implements Promotion {

    SKUItem skuItem;
    int requiredNoOfItems;
    int fixedPrice;

    public MultipleItemsOfSingleSKUPromotion(SKUItem skuItem, int requiredNoOfItems, int price) {
        this.skuItem = skuItem;
        this.requiredNoOfItems = requiredNoOfItems;
        this.fixedPrice = price;
    }

    public int apply(Map<SKUItem, Integer> skuItemsWithCount) {

        int applicablePrice = 0;
        if (skuItemsWithCount.containsKey(skuItem) && skuItemsWithCount.get(skuItem) >= requiredNoOfItems) {
            int skuItemCount = skuItemsWithCount.get(skuItem);

            int noOfTimesPromotionApplicable = skuItemCount / requiredNoOfItems;

            applicablePrice = noOfTimesPromotionApplicable * fixedPrice;

            skuItemsWithCount.put(skuItem, skuItemCount - noOfTimesPromotionApplicable * requiredNoOfItems);
        }

        return applicablePrice;
    }
}
