package com.assignment.promotions;

import com.assignment.model.SKUItem;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class UnitPricePromotionTest {

    UnitPricePromotion promotion;

    @Before
    public void setUp() throws Exception {
        promotion = new UnitPricePromotion();
    }

    @Test
    public void shouldReturnZeroWhenNoItemLeft() {
        Map<SKUItem, Integer> skuItems = new HashMap();

        skuItems.put(SKUItem.A, 0);
        skuItems.put(SKUItem.B, 0);
        skuItems.put(SKUItem.C, 0);

        int actualOrderValue = promotion.apply(skuItems);

        Assert.assertEquals(actualOrderValue, 0);
    }

    @Test
    public void shouldReturnTotalUnitPriceForAllApplicableItems() {
        Map<SKUItem, Integer> skuItems = new HashMap();

        skuItems.put(SKUItem.A, 2);
        skuItems.put(SKUItem.B, 1);

        int actualOrderValue = promotion.apply(skuItems);

        Assert.assertEquals(actualOrderValue, 130);
    }
}