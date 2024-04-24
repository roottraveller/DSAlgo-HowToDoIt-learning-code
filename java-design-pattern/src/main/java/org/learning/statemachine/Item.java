package org.learning.statemachine;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Item {
    private String name;
    private double price;
    private long stockCount;

    // Item class representing items in the vending machine
}

