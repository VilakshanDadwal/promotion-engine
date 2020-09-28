package com.assignment;

import com.assignment.model.Cart;
import com.assignment.model.SKUItem;
import com.assignment.promotions.Promotion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PromotionChainTest {

    PromotionChain promotionChain;

    @Before
    public void setUp() throws Exception {
        Promotion promotion1 = skuItems -> 10;
        Promotion promotion2 = skuItems -> 5;
        Promotion promotion3 = skuItems -> 0;

        List<Promotion> promotions = Arrays.asList(promotion1, promotion2, promotion3);
        promotionChain = new PromotionChain(promotions);
    }

    @Test
    public void shouldApplyPromotionsAndCalculateOrderValue() {

        Map<SKUItem, Integer> skuItemsWithCount = new HashMap<>();

        skuItemsWithCount.put(SKUItem.A, 1);
        skuItemsWithCount.put(SKUItem.B, 1);
        skuItemsWithCount.put(SKUItem.C, 1);

        int actualOrderValue = promotionChain.evaluate(new Cart(skuItemsWithCount));

        Assert.assertEquals(actualOrderValue, 15);

    }

}