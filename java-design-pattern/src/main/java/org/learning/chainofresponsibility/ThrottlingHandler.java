package org.learning.chainofresponsibility;

public class ThrottlingHandler extends AuthenticationHandler {
    @Override
    public boolean authenticate(String email, String password) {
        // Check for rate limiting
        System.out.println("ThrottlingHandler: Checking rate limiting:OK");

        // Step 3: Check the next handler in the chain
        return checkNextHandler(email, password);
    }
}
