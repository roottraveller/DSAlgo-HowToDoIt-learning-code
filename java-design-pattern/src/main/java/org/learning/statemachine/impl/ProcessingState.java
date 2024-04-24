package org.learning.statemachine.impl;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.learning.statemachine.IState;
import org.learning.statemachine.Item;
import org.learning.statemachine.VendingMachineState;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class ProcessingState extends VendingMachineState {
    private ItemInventory itemInventory = new ItemInventory();

    @Override
    public IState transactionProcessed(Item item) {
        itemInventory.isStockAvailable(item);
        itemInventory.decreaseStock(item, 1);
        System.out.println("ProcessingState: Transaction processed. Moving to the next state...");
        return new SoldState().transactionProcessed(item);
    }
}

