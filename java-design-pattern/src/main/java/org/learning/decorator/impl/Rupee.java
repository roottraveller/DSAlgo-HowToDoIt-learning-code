package org.learning.decorator.impl;

import org.learning.decorator.Currency;

// Step 2: Implement concrete components (Concrete Component)
public class Rupee implements Currency {
    @Override
    public String getSymbol() {
        return "INR";
    }
}
