package com.assignment.promotions;

import com.assignment.model.SKUItem;

import java.util.Map;


/**
 * Buy SKU 1 and SKU 2 for a fixed fixedPrice promotion.
 * skuItemOne and skuItemTwo are the items which need to be present
 * fixedPrice is the applicable price when both occur in the cart.
 */
public class GroupedSKUItemsPromotion implements Promotion {

    SKUItem skuItemOne;
    SKUItem skuItemTwo;
    int fixedPrice;


    public GroupedSKUItemsPromotion(SKUItem skuItemOne, SKUItem skuItemTwo, int fixedPrice) {
        this.skuItemOne = skuItemOne;
        this.skuItemTwo = skuItemTwo;
        this.fixedPrice = fixedPrice;
    }

    public int apply(Map<SKUItem, Integer> skuItemsWithCount) {
        int applicablePrice = 0;

        if (skuItemsWithCount.containsKey(skuItemOne) && skuItemsWithCount.containsKey(skuItemTwo)) {
            int noOfTimesPromotionApplicable = Math.min(skuItemsWithCount.get(skuItemOne), skuItemsWithCount.get(skuItemTwo));
            applicablePrice = noOfTimesPromotionApplicable * fixedPrice;
        }
        return applicablePrice;
    }
}
