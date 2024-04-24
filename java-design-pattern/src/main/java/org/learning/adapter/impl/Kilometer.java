package org.learning.adapter.impl;

import lombok.Data;
import org.learning.adapter.Unit;

@Data
public class Kilometer implements Unit {
    private double value;

    @Override
    public double getValue() {
        return value;
    }

    // do stuff
}

