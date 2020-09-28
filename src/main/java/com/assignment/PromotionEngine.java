package com.assignment;

import com.assignment.promotions.Promotion;

import java.util.Arrays;
import java.util.List;

import static com.assignment.SKUItem.*;

public class PromotionEngine {

    public static void main(String[] args) {

        Cart cart = new Cart (Arrays.asList(A, B, C, D));
        List<Promotion> promotions = Arrays.asList();

        PromotionChain promotionChain = new PromotionChain(promotions);
        int totalOrderValue = promotionChain.evaluate(cart);

        System.out.println(totalOrderValue);
    }
}
