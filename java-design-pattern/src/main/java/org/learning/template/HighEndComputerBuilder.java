package org.learning.template;

public class HighEndComputerBuilder extends ComputerBuilderTemplate {

    @Override
    protected void addMotherboard() {
        System.out.println("Adding high-end motherboard");
    }

    @Override
    protected void addProcessor() {
        System.out.println("Adding high-end processor");
    }

    @Override
    protected void addMemory() {
        System.out.println("Adding high-end memory");
    }

    @Override
    protected void addStorage() {
        System.out.println("Adding high-end storage");
    }
}

