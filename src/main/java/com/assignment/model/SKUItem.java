package com.assignment.model;

public enum SKUItem {
    A(50), B(30), C(20), D(15);

    private int unitPrice;

    SKUItem(int unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getUnitPrice() {
        return unitPrice;
    }
}
