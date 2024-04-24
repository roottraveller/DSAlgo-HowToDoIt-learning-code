package org.learning.decorator.impl;

import org.learning.decorator.Currency;

public class Dollar implements Currency {
    @Override
    public String getSymbol() {
        return "USD";
    }
}

