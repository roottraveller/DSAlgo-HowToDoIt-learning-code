package org.leetcode.logger_rate_limiter;


public class Main {

    // https://leetcode.ca/2016-11-23-359-Logger-Rate-Limiter/
    public static void main(String[] args) {
        Logger logger = new Logger();
        System.out.println(logger.shouldPrintMessage(1, "foo"));  // true
        System.out.println(logger.shouldPrintMessage(2, "bar"));  // true
        System.out.println(logger.shouldPrintMessage(3, "foo"));  // false
        System.out.println(logger.shouldPrintMessage(8, "bar"));  // false
        System.out.println(logger.shouldPrintMessage(10, "foo")); // false
        System.out.println(logger.shouldPrintMessage(11, "foo")); // true
    }
}