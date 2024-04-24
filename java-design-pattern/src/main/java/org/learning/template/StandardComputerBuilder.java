package org.learning.template;

// Step 4: Create concrete subclasses that implement the abstract methods
public class StandardComputerBuilder extends ComputerBuilderTemplate {

    @Override
    protected void addMotherboard() {
        System.out.println("Adding standard motherboard");
    }

    @Override
    protected void addProcessor() {
        System.out.println("Adding standard processor");
    }

    @Override
    protected void addMemory() {
        System.out.println("Adding standard memory");
    }

    @Override
    protected void addStorage() {
        System.out.println("Adding standard storage");
    }
}

