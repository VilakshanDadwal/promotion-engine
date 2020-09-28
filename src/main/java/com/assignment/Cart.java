package com.assignment;

import java.util.List;

public class Cart {

    List<SKUItem> skuItems;

    public Cart(List<SKUItem> skuItems) {
        this.skuItems = skuItems;
    }

    public List<SKUItem> getSkuItems() {
        return skuItems;
    }
}
