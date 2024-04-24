package org.learning.chainofresponsibility;

public class UserExistsHandler extends AuthenticationHandler {
    @Override
    public boolean authenticate(String email, String password) {
        // Check if email address is registered
        System.out.println("UserExistsHandler: Checking if user exists:OK");

        // Step 4: Check the next handler in the chain
        return checkNextHandler(email, password);
    }
}
