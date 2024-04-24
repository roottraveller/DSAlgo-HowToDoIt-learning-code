package org.learning.statemachine;

// Step 3: Define the state interface
public interface IState {
    IState transactionProcessed(Item item);
}

