package org.learning.statemachine.impl;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.learning.statemachine.IState;
import org.learning.statemachine.Item;
import org.learning.statemachine.VendingMachineState;

@EqualsAndHashCode(callSuper = true)
@Data
public class IdealState extends VendingMachineState {

    @Override
    public IState transactionProcessed(Item item) {
        System.out.println("IdealState: Transaction processed. Moving to the next state...");
        return new ProcessingState().transactionProcessed(item);
    }
}

