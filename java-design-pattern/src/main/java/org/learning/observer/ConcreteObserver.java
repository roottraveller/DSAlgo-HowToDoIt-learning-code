package org.learning.observer;

// Step 4: Implement the Observer
public class ConcreteObserver implements Observer {
    @Override
    public void update(String state) {
        System.out.println("Observer received updated state: " + state);
    }
}

