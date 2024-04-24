package org.learning.proxy;

import org.learning.proxy.impl.RealDatabase;

/*
 * Proxy Pattern involves the utilization of a proxy to stand in for another object, known as the subject,
 * when interacting with clients. This arrangement shields the real subject from direct interaction with clients.
 * Example:
 * java.rmi.*
 * java.lang.reflect.Proxy
 *
 *
 * https://medium.com/javarevisited/how-to-implement-proxy-design-pattern-using-java-719c06a0ae34
 */


// Step 1: Create the proxy class, which implements the same interface as the real object
public class DatabaseProxy implements Database {
    private final RealDatabase realDatabase;
    private final String userRole;

    public DatabaseProxy(String userRole) {
        this.realDatabase = new RealDatabase();
        this.userRole = userRole;
    }

    // Step 4: intercepting requests and performing additional tasks
    @Override
    public void fetchData() {
        // Step 5: Perform additional tasks (e.g., security checks) before delegating the request to the real object
        if (userRole.equals("admin")) {
            realDatabase.fetchData();
        } else {
            System.out.println("Access denied. You do not have permission to fetch data.");
        }
    }
}
