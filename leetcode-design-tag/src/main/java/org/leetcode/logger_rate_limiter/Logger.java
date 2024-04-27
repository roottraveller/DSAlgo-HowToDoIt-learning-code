package org.leetcode.logger_rate_limiter;

import java.util.HashMap;
import java.util.Map;

public class Logger {
    private final Map<String, Integer> lastPrinted;

    public Logger() {
        lastPrinted = new HashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        if (!lastPrinted.containsKey(message)
                || timestamp - lastPrinted.get(message) >= 10) {
            lastPrinted.put(message, timestamp); // Imp
            return true;
        } else {
            return false;
        }
    }
}
