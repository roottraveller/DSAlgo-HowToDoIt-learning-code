package org.learning.factory.impl;

import lombok.Data;
import org.learning.factory.Currency;

@Data
public class Dollar implements Currency {
    @Override
    public String getSymbol() {
        return "USD";
    }

    // do stuff
}
