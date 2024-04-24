package org.learning.decorator;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class DollerDecorator extends Decorator {
    @Override
    public String getSymbol() {
        return "USD";
    }

    @Override
    public String getCountry() {
        return "USA";
    }
}
