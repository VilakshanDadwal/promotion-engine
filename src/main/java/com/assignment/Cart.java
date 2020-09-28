package com.assignment;

import java.util.List;
import java.util.Map;

public class Cart {

    Map<SKUItem, Integer> skuItemsWithCount;

    public Cart(Map<SKUItem, Integer> skuItemsWithCount) {
        this.skuItemsWithCount = skuItemsWithCount;
    }

    public Map<SKUItem, Integer> getSkuItemsWithCount() {
        return skuItemsWithCount;
    }
}
