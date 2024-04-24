package org.learning.statemachine;

// Step 5: Define the inventory interface
public interface Inventory {
    void loadInventory();

    boolean isStockAvailable(Item currentItem);

    boolean decreaseStock(Item currentItem, long count);
}

