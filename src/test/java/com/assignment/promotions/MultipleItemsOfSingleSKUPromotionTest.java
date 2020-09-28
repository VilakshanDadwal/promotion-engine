package com.assignment.promotions;

import com.assignment.model.SKUItem;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class MultipleItemsOfSingleSKUPromotionTest {

    MultipleItemsOfSingleSKUPromotion promotion;

    @Before
    public void setUp() {
        promotion = new MultipleItemsOfSingleSKUPromotion(SKUItem.A, 3, 130);
    }

    @Test
    public void shouldReturnZeroIfSkuItemNotPresent() {

        Map<SKUItem, Integer> skuItems = new HashMap();

        skuItems.put(SKUItem.B, 2);

        int actualOrderValue = promotion.apply(skuItems);

        Assert.assertEquals(actualOrderValue, 0);
    }

    @Test
    public void shouldReturnZeroIfNotApplicableForSkuItem() {

        Map<SKUItem, Integer> skuItems = new HashMap();

        skuItems.put(SKUItem.A, 2);

        int actualOrderValue = promotion.apply(skuItems);

        Assert.assertEquals(actualOrderValue, 0);
    }

    @Test
    public void shouldReturnCorrectPriceValueWhenPromotionApplicable() {

        Map<SKUItem, Integer> skuItems = new HashMap();

        skuItems.put(SKUItem.A, 3);

        int actualOrderValue = promotion.apply(skuItems);

        Assert.assertEquals(actualOrderValue, 130);
    }


    @Test
    public void shouldReturnCorrectPriceWhenPromotionApplicableMultipleTimes() {

        Map<SKUItem, Integer> skuItems = new HashMap();

        skuItems.put(SKUItem.A, 7);

        int actualOrderValue = promotion.apply(skuItems);

        Assert.assertEquals(actualOrderValue, 260);
    }

}