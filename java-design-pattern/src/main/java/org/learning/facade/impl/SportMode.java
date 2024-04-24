package org.learning.facade.impl;

import org.learning.facade.DrivingMode;

// Step 2: Implement concrete driving modes (Concrete Component)
public class SportMode implements DrivingMode {
    @Override
    public void activate() {
        // Implement specific actions for activating sport mode
        manualTransmission();
        paddleShift();
        disableTractionControl();
        launchControl();
    }

    // Private methods representing specific actions of sport mode
    private void launchControl() {
    }

    private void disableTractionControl() {
    }

    private void paddleShift() {
    }

    private void manualTransmission() {
    }
}
