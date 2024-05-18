package org.leetcode.moving_average_from_data_stream_346;

public class Main {

    public static void main(String[] args) {
        MovingAverage m = new MovingAverage(3);
        System.out.println(m.next(1));    // returns 1.0
        System.out.println(m.next(10));   // returns 5.5
        System.out.println(m.next(3));    // returns 4.66667
        System.out.println(m.next(5));    // returns 6.0
    }
}
