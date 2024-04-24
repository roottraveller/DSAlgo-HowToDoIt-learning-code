package org.learning.factory;

import org.learning.factory.impl.Dollar;
import org.learning.factory.impl.Rupee;

/*
 * The Factory Method Pattern encapsulates the object creation process and allows it to be controlled by subclasses or specific implementations.
 * This promotes loose coupling between the client code and the created objects, as the client code interacts with the factory method interface
 * rather than directly with the concrete classes being instantiated.
 * Example:
 * getInstance() method of the java.util.Calendar
 * asList() method in the java.util.Arrays
 * emptyList(), singletonList(), and unmodifiableList() methods in the java.util.Collections
 *
 *
 * https://javarevisited.blogspot.com/2011/12/factory-design-pattern-java-example.html#axzz7YGkYs1WH
 * https://javarevisited.blogspot.com/2013/01/difference-between-factory-and-abstract-factory-design-pattern-java.html#axzz7YGkYs1WH
 */

// Step 1: Define a factory class which hides the object creation logic
public class CurrencyFactory {

    // Step 2: Define a static factory method
    public static Currency createCurrency(String country) {
        // Step 3: Implement logic to determine which currency to create
        if (country.equalsIgnoreCase("INDIA")) {
            // Step 4: Define concrete product classes
            return new Rupee();
        } else if (country.equalsIgnoreCase("USA")) {
            // Step 4: Define concrete product classes
            return new Dollar();
        } else {
            throw new IllegalArgumentException("currency does not exist for this country");
        }
    }
}


