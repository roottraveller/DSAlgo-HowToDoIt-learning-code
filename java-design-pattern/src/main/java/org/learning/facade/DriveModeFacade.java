package org.learning.facade;

import org.learning.facade.impl.ComfortMode;
import org.learning.facade.impl.SportMode;

/*
 * The Facade Pattern simplifies the usage of a complex system by providing a unified interface that hides the complexities
 * of the underlying subsystems. It acts as a single entry point to access multiple subsystems or interfaces, making it easier
 * for clients to interact with the system. Its purpose is to hide the complexity of an interface or a subsystem.
 * Example:
 * sort, binarySearch, reverse from java.util.Collections
 * java.net.URL hiding the complexities of network protocols, connection management, and data retrieval etc
 *
 * Source: https://javarevisited.blogspot.com/2015/01/adapter-vs-decorator-vs-facade-vs-proxy-pattern-java.html#axzz7YGkYs1WH
 */


// Step 3: Create a facade class to simplify interactions with driving modes, and hides complexity
public class DriveModeFacade {
    public static void selectMode(DriveMode driveMode) {
        switch (driveMode) {
            case COMFORT:
                DrivingMode comfortMode = new ComfortMode();
                comfortMode.activate();
                break;
            case SPORT:
                DrivingMode sportMode = new SportMode();
                sportMode.activate();
                break;
        }
    }
}

