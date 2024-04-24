package org.learning.template;


/*
 * The Template Method Pattern defines the template method that contains the algorithm's skeleton.
 * It may also provide default implementations for some steps of the algorithm. It allows subclasses
 * to provide specific implementations for certain steps while keeping the overall structure of the algorithm intact.
 * Example:
 * sort() method in the Collections class
 *
 *
 * https://javarevisited.blogspot.com/2022/10/template-method-pattern-in-java-example.html
 */


public abstract class ComputerBuilderTemplate {

    // Step 1: Define the template method that outlines the overall algorithm
    // This method defines the sequence of steps required to build a computer
    public final void buildComputer() {
        addMotherboard();
        addProcessor();
        addMemory();
        addStorage();
        finalizeBuild();
    }

    // Step 2: Define abstract methods that represent the individual steps of the algorithm
    protected abstract void addMotherboard();

    protected abstract void addProcessor();

    protected abstract void addMemory();

    protected abstract void addStorage();

    // Step 3: Optionally, provide a default implementation for any common steps
    protected void finalizeBuild() {
        System.out.println("Computer build finalized");
    }
}

