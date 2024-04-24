package org.learning.observer;

import java.util.ArrayList;
import java.util.List;

/*
 * The Observer Pattern, also known as the Publisher/Subscriber Pattern, establishes a one-to-many dependency
 * relationship between objects, where multiple observers (subscribers) are notified when the state of a subject
 * (publisher) changes. This pattern enables loosely coupled communication between objects, as observers are not
 *  directly dependent on the subject but instead subscribe to its changes.
 * Example:
 * java.util.EventListener
 *
 *
 * https://javarevisited.blogspot.com/2011/12/observer-design-pattern-java-example.html#axzz7YGkYs1WH
 */


// Step 2: Implement the Subject
public class ConcreteSubject implements Subject {
    private final List<Observer> observers = new ArrayList<>();
    private String state;

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(state); // Notify each observer
        }
    }

    @Override
    public void setState(String state) {
        this.state = state;
        notifyObservers(); // Notify observers when the state changes
    }
}

