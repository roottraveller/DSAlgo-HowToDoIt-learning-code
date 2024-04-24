package org.learning.factory.impl;

import org.learning.factory.Currency;

public class Rupee implements Currency {
    @Override
    public String getSymbol() {
        return "INR";
    }
}
