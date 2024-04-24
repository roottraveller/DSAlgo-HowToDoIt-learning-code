package org.learning.observer;

// Step 1: Define the Subject Interface
public interface Subject {
    void addObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers();

    void setState(String state);
}

