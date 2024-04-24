package org.learning.visitor;

import org.learning.visitor.impl.Book;
import org.learning.visitor.impl.Electronics;

// Step 1: Define the visitor interface
public interface ShippingCostCalculator {
    void calculate(Book book);

    void calculate(Electronics electronics);
}

