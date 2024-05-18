package org.leetcode.hit_counter_362;

import java.util.LinkedList;
import java.util.Queue;

public class HitCounter {
    private final Queue<Integer> hits;

    public HitCounter() {
        hits = new LinkedList<>();
    }

    public void hit(int timestamp) {
        hits.add(timestamp);
    }

    public int getHits(int timestamp) {
        // Remove entries older than 5 minutes (300 seconds) from the current timestamp
        while (!hits.isEmpty() && timestamp - hits.peek() >= 300) {
            hits.poll();
        }
        return hits.size();
    }
}
