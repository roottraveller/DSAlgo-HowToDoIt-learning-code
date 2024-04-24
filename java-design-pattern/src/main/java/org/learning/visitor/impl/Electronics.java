package org.learning.visitor.impl;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.learning.visitor.Product;
import org.learning.visitor.ShippingCostCalculator;

@EqualsAndHashCode(callSuper = true)
@Data
public class Electronics extends Product {
    private final double weight;

    public Electronics(double weight) {
        this.weight = weight;
    }

    @Override
    public void accept(ShippingCostCalculator calculator) {
        calculator.calculate(this); // Delegate calculation to visitor
    }

}
