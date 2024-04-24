package org.learning.singleton;

/*
 * The Singleton Pattern restricts a class to have only one instance throughout the runtime of an application.
 * It's commonly used when you want precisely one object to coordinate actions across the system.
 * Example:
 * java.lang.Runtime
 * java.lang.System
 * java.util.UUID
 *
 *
 * https://javarevisited.blogspot.com/2014/05/double-checked-locking-on-singleton-in-java.html#axzz7YGkYs1WH
 * 1- The static keyword ensures that there's only one instance of the variable shared across all instances of the class.
 * 2- The volatile keyword enforces that any read or write of the variable is done directly to and from the main memory (RAM),
 *    bypassing the thread's cache. This ensures that changes made to the variable by one thread are immediately visible to other threads.
 */


import lombok.Data;

@Data
public class SingletonClassDemo {
    // Step 1: Private static volatile instance variable
    private static volatile SingletonClassDemo INSTANCE;

    // Other fields can be added here
    private String field;

    // Step 2: Private constructor to prevent direct instantiation
    private SingletonClassDemo() {
        // Initialization code, if any
    }

    // Step 3: Static method to get the singleton instance
    public static SingletonClassDemo getInstance() {
        // Double-checked locking for thread safety
        if (INSTANCE == null) {
            // Synchronized block to ensure thread safety
            synchronized (SingletonClassDemo.class) {
                // Double check for null instance inside synchronized block
                if (INSTANCE == null) {
                    INSTANCE = new SingletonClassDemo();
                }
            }
        }
        return INSTANCE;
    }

    // Other methods and fields can be added here

}

