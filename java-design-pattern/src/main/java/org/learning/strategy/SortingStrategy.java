package org.learning.strategy;

/*
 * The Strategy Pattern allows defining a family of algorithms (strategy), encapsulating each one, and making them
 * interchangeable.
 * It promotes flexibility by enabling dynamic selection of algorithms at runtime without modifying client code, thus
 *  adhering to the Open/Closed Principle.
 * Example:
 * Sorting Algorithms
 *
 *
 * https://javarevisited.blogspot.com/2022/12/strategy-design-pattern-in-java-example.html
 */


import lombok.Setter;

// Step 3: Define the strategy class
@Setter
public class SortingStrategy {
    private SortingAlgorithm algorithm;

    public SortingStrategy(SortingAlgorithm algorithm) {
        this.algorithm = algorithm;
    }

    public void performSort(int[] array) {
        algorithm.sort(array);
    }
}
