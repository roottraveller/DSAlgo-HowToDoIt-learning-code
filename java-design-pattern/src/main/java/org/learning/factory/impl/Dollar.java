package org.learning.factory.impl;

import org.learning.factory.Currency;

public class Dollar implements Currency {
    @Override
    public String getSymbol() {
        return "USD";
    }
}
