package com.assignment;

import com.assignment.promotions.Promotion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

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

        int actualOrderValue = promotionChain.evaluate(new Cart(Arrays.asList(SKUItem.A)));

        Assert.assertEquals(actualOrderValue, 15);

    }

}