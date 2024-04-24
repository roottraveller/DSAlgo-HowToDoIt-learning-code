package org.learning.statemachine.impl;

import lombok.Data;
import org.learning.statemachine.*;

@Data
// Step 2: Define the context class
public class VendingMachine implements IMachine {
    private IState state;
    private final Inventory itemInventory = new ItemInventory();
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

