package org.learning.visitor;

// Step 2: Define the abstract product class
public abstract class Product {
    protected abstract void accept(ShippingCostCalculator calculator);
}

