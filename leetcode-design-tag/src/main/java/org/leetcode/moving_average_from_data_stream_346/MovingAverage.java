package org.leetcode.moving_average_from_data_stream_346;

import java.util.LinkedList;
import java.util.Queue;

public class MovingAverage {
    private final int size;
    private final Queue<Integer> queue;
    private double sum;

    /**
     * Initialize the object with the size of the window size.
     */
    public MovingAverage(int size) {
        this.size = size;
        this.queue = new LinkedList<>();
        this.sum = 0;
    }

    /**
     * Returns the moving average of the last size values of the stream.
     */
    public double next(int val) {
        if (queue.size() == size) {
            sum -= queue.poll();
        }
        queue.offer(val);
        sum += val;
        return sum / queue.size();
    }

}
