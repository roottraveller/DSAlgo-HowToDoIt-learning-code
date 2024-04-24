package org.learning.statemachine.impl;

import org.learning.statemachine.Inventory;
import org.learning.statemachine.Item;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

// Step 6: Define the concrete inventory class
public class ItemInventory implements Inventory {
    private final Map<Item, Long> itemInventoryMap = new ConcurrentHashMap<>();

    @Override
    public void loadInventory() {
        // Load initial inventory
        System.out.println("Inventory loaded successfully.");
    }

    @Override
    public boolean isStockAvailable(Item currentItem) {
        // Check if stock is available for the given item
        System.out.println("Stock available for " + currentItem.getName());
        return false;
    }

    @Override
    public boolean decreaseStock(Item currentItem, long count) {
        // Decrease stock count for the given item
        System.out.println("Stock decreased for " + currentItem.getName());
        return true;
    }
}


