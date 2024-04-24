package org.learning.decorator;

/*
 * The Decorator Pattern enhances the functionality of objects dynamically by wrapping them with decorator objects,
 * allowing new features to be added without altering their original classes. It is used when subclassing becomes impractical
 * or when different combinations of functionalities are needed for independent objects. Additionally, it's employed to add
 * functionality to individual objects at runtime, rather than applying changes to all objects.
 * Example:
 * BufferedInputStream which adds buffering capabilities to a FileInputStream without modifying its class.
 *
 * https://javarevisited.blogspot.com/2011/11/decorator-design-pattern-java-example.html#axzz7YGkYs1WH
 */


// Step 3: Create an abstract decorator class (Decorator)
public abstract class Decorator implements Currency {
    // Declare abstract method for additional functionality
    public abstract String getCountry();
}

