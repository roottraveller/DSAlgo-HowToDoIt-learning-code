package org.learning.factory.impl;

import lombok.Data;
import org.learning.factory.Currency;

@Data
public class Rupee implements Currency {
    @Override
    public String getSymbol() {
        return "INR";
    }

    // do stuff
}
