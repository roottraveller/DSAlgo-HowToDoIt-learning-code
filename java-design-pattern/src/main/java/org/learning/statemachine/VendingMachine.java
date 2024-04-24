package org.learning.statemachine;

import lombok.Data;
import org.learning.statemachine.impl.IdealState;
import org.learning.statemachine.impl.ItemInventory;

/*
 * The State Pattern encapsulates the behavior of an object into different states and allows the object to alter its
 * behavior when its internal state changes. This pattern is particularly useful when an object's behavior depends on
 * its state and needs to change dynamically at runtime.
 * Example:
 * ReentrantLock class in java.util.concurrent.locks package
 *
 *
 * https://javarevisited.blogspot.com/2021/07/state-design-pattern-example-java-vending-machine.html#axzz7YGkYs1WH
 */


@Data
// Step 2: Define the context class
public class VendingMachine implements IMachine {
    private final Inventory itemInventory = new ItemInventory();
    private IState state;
    private Item currentItem;

    public VendingMachine() {
        initialize(); // Initialize the vending machine
    }

    private void initialize() {
//        itemInventory.loadInventory();
        this.state = new IdealState();
        System.out.println("Vending machine initialized.");
    }

    public void loadInventory() {
        itemInventory.loadInventory();
    }

    public void selectItem(Item item) {
        this.currentItem = item;
        System.out.println("Item selected: " + item.getName());
    }

    public void insertCoin(Coin coin) {
        System.out.println("Coin inserted: " + coin);
    }

    // Method to process the transaction
    public void processTransaction() {
        System.out.println("Processing transaction...");
        state.transactionProcessed(this.currentItem);
    }
}

