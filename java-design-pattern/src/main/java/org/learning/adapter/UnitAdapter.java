package org.learning.adapter;

import org.learning.adapter.impl.Kilometer;
import org.learning.adapter.impl.Miles;

/*
 * The Adapter pattern facilitates the collaboration between two incompatible classes that cannot otherwise interact.
 * It acts as a bridge between the two incompatible interfaces, enabling them to work together seamlessly without
 * changing any code on either side.
 * Example:
 * asList() method provided by java.util.Arrays
 * BufferedReader, Scanner, FileInputStream
 *
 *
 * https://javarevisited.blogspot.com/2016/08/adapter-design-pattern-in-java-example.html#axzz7YGkYs1WH
 */


// Step 1: Use the Adapter classes to adapt the Adaptee classes to the Target interface.
public class UnitAdapter {
    public double getKm(Miles miles) {
        return miles.getValue() * 1.6;
    }

    public double getMiles(Kilometer kilometer) {
        return kilometer.getValue() * 0.6;
    }
}
