package com.assignment.promotions;

import com.assignment.model.SKUItem;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class GroupedSKUItemsPromotionTest {

    GroupedSKUItemsPromotion promotion;

    @Before
    public void setUp() throws Exception {

        promotion = new GroupedSKUItemsPromotion(SKUItem.C, SKUItem.D, 30);
    }

    @Test
    public void shouldReturnZeroIfNotApplicableForSkuItem() {

        Map<SKUItem, Integer> skuItems = new HashMap();

        skuItems.put(SKUItem.C, 2);

        int actualOrderValue = promotion.apply(skuItems);

        Assert.assertEquals(actualOrderValue, 0);
    }

    @Test
    public void shouldReturnCorrectPriceValueWhenPromotionApplicable() {

        Map<SKUItem, Integer> skuItems = new HashMap();

        skuItems.put(SKUItem.C, 1);
        skuItems.put(SKUItem.D, 1);

        int actualOrderValue = promotion.apply(skuItems);

        Assert.assertEquals(actualOrderValue, 30);
    }

    @Test
    public void shouldReturnCorrectPriceValueWhenPromotionApplicableMultipleTimes() {

        Map<SKUItem, Integer> skuItems = new HashMap();

        skuItems.put(SKUItem.C, 2);
        skuItems.put(SKUItem.D, 3);

        int actualOrderValue = promotion.apply(skuItems);

        Assert.assertEquals(actualOrderValue, 60);
    }

}