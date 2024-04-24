package org.learning.facade.impl;

import org.learning.facade.DrivingMode;

public class ComfortMode implements DrivingMode {
    @Override
    public void activate() {
        // Implement specific actions for activating comfort mode
        automaticTransmission();
        cruiseControl();
        mildSuspension();
    }

    // Private methods representing specific actions of comfort mode
    private void mildSuspension() { }
    private void cruiseControl() { }
    private void automaticTransmission() { }
}
