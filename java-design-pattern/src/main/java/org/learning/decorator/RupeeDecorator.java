package org.learning.decorator;


import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
// Step 4: Implement abstract decorators (Concrete Decorator)
public class RupeeDecorator extends Decorator {
    @Override
    public String getSymbol() {
        return "INR";
    }

    @Override
    public String getCountry() {
        return "India";
    }
}
