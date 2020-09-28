package com.assignment.promotions;


import com.assignment.model.SKUItem;

import java.util.Map;

@FunctionalInterface
public interface Promotion {

    int apply(Map<SKUItem, Integer> skuItems);
}
