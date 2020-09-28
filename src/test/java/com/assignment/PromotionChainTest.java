package com.assignment;

import com.assignment.model.Cart;
import com.assignment.model.SKUItem;
import com.assignment.promotions.GroupedSKUItemsPromotion;
import com.assignment.promotions.MultipleItemsOfSingleSKUPromotion;
import com.assignment.promotions.Promotion;
import com.assignment.promotions.UnitPricePromotion;
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
    public void setUp() {
        Promotion promotion1 = new MultipleItemsOfSingleSKUPromotion(SKUItem.A, 3, 130);
        Promotion promotion2 = new MultipleItemsOfSingleSKUPromotion(SKUItem.B, 2, 45);
        Promotion promotion3 = new GroupedSKUItemsPromotion(SKUItem.C, SKUItem.D, 30);
        Promotion promotion4 = new UnitPricePromotion();

        List<Promotion> activePromotions = Arrays.asList(promotion1, promotion2, promotion3, promotion4);
        promotionChain = new PromotionChain(activePromotions);
    }

    @Test
    public void shouldApplyPromotionsAndCalculateOrderValue_ScenarioA() {

        Map<SKUItem, Integer> skuItemsWithCount = new HashMap<>();

        skuItemsWithCount.put(SKUItem.A, 1);
        skuItemsWithCount.put(SKUItem.B, 1);
        skuItemsWithCount.put(SKUItem.C, 1);

        int actualOrderValue = promotionChain.evaluate(new Cart(skuItemsWithCount));

        Assert.assertEquals(actualOrderValue, 100);

    }


    @Test
    public void shouldApplyPromotionsAndCalculateOrderValue_ScenarioB() {

        Map<SKUItem, Integer> skuItemsWithCount = new HashMap<>();

        skuItemsWithCount.put(SKUItem.A, 5);
        skuItemsWithCount.put(SKUItem.B, 5);
        skuItemsWithCount.put(SKUItem.C, 1);

        int actualOrderValue = promotionChain.evaluate(new Cart(skuItemsWithCount));

        Assert.assertEquals(actualOrderValue, 370);

    }

    @Test
    public void shouldApplyPromotionsAndCalculateOrderValue_ScenarioC() {

        Map<SKUItem, Integer> skuItemsWithCount = new HashMap<>();

        skuItemsWithCount.put(SKUItem.A, 3);
        skuItemsWithCount.put(SKUItem.B, 5);
        skuItemsWithCount.put(SKUItem.C, 1);
        skuItemsWithCount.put(SKUItem.D, 1);

        int actualOrderValue = promotionChain.evaluate(new Cart(skuItemsWithCount));

        Assert.assertEquals(actualOrderValue, 280);

    }

    @Test
    public void shouldApplyPromotionsAndCalculateOrderValue_ExtraScenario() {

        Map<SKUItem, Integer> skuItemsWithCount = new HashMap<>();

        skuItemsWithCount.put(SKUItem.A, 3);
        skuItemsWithCount.put(SKUItem.B, 5);
        skuItemsWithCount.put(SKUItem.C, 2);
        skuItemsWithCount.put(SKUItem.D, 3);

        int actualOrderValue = promotionChain.evaluate(new Cart(skuItemsWithCount));

        Assert.assertEquals(actualOrderValue, 325);

    }
}