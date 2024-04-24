package org.learning.chainofresponsibility;


/*
 * The Chain of Responsibility Pattern involves passing a request along a chain of handler objects,
 * with each handler having the opportunity to handle the request or pass it to the next handler in the chain.
 * This pattern enables loose coupling between the sender and receiver of a request, allowing multiple objects
 * to participate in handling the request.
 * Example:
 * java.util.logging.Logger
 */

public abstract class AuthenticationHandler {
    private AuthenticationHandler nextHandler;

    public abstract boolean authenticate(String email, String password);

    // Step 1: Method to set the next handler in the chain
    public boolean setNextHandler(AuthenticationHandler nextHandler) {
        this.nextHandler = nextHandler;
        return true;
    }

    // Step 2: Method to check the next handler in the chain
    boolean checkNextHandler(String email, String password) {
        if (nextHandler == null) {
            return true; // No more handlers in the chain
        }
        return nextHandler.authenticate(email, password);
    }
}
