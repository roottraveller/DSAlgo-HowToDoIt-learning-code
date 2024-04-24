package org.learning.proxy.impl;

import org.learning.proxy.Database;

public class RealDatabase implements Database {
    @Override
    public void fetchData() {
        System.out.println("Fetching data from the database...");
    }
}

