package org.learning.visitor.impl;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.learning.visitor.Product;
import org.learning.visitor.ShippingCostCalculator;

// Step 3: Implement concrete product classes
@EqualsAndHashCode(callSuper = true)
@Data
public class Book extends Product {
    private final double weight;

    public Book(double weight) {
        this.weight = weight;
    }

    @Override
    public void accept(ShippingCostCalculator calculator) {
        calculator.calculate(this); // Delegate calculation to visitor
    }

}
