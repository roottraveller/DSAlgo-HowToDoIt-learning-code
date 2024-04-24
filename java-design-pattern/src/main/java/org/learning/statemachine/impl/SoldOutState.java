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
public class SoldOutState extends VendingMachineState {

    @Override
    public IState transactionProcessed(Item item) {
        System.out.println("Vending machine is sold out.");
        return null;
    }
}

