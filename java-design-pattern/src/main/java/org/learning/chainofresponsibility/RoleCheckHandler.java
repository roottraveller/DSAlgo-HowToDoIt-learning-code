package org.learning.chainofresponsibility;

public class RoleCheckHandler extends AuthenticationHandler {
    @Override
    public boolean authenticate(String email, String password) {
        // Check if the user has admin role
        System.out.println("RoleCheckHandler: Checking user role:OK");

        // Step 5: Check the next handler in the chain
        return checkNextHandler(email, password);
    }
}

