package org.learning.visitor;

import org.learning.visitor.impl.Book;
import org.learning.visitor.impl.Electronics;

/*
 * The Visitor Pattern separates an algorithm from the object structure it operates on by defining a new operation in
 *  a separate visitor class. It enables the addition of new operations to an object structure without modifying its
 * classes, promoting extensibility and maintainability.
 * Example:
 * java.nio.file
 *
 *
 * https://medium.com/javarevisited/how-to-implement-visitor-design-pattern-using-java-99b6fcdd48ef
 */


// Step 4: Implement concrete visitor
public class StandardShippingCostCalculator implements ShippingCostCalculator {
    @Override
    public void calculate(Book book) {
        double cost = book.getWeight() * 0.5;
        System.out.println("Standard shipping cost for book: $" + cost);
    }

    @Override
    public void calculate(Electronics electronics) {
        double cost = electronics.getWeight() * 1.2;
        System.out.println("Standard shipping cost for electronics: $" + cost);
    }
}
