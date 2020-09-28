package com.assignment.promotions;

import com.assignment.SKUItem;

import java.util.List;

@FunctionalInterface
public interface Promotion {

    int apply(List<SKUItem> skuItems);
}
