package org.leetcode.hit_counter_362;

import java.util.ArrayDeque;
import java.util.Deque;

public class HitCounter2 {
    private final Deque<Integer> hits;

    public HitCounter2() {
        hits = new ArrayDeque<>();
    }

    public void hit(int timestamp) {
        hits.addLast(timestamp);
    }

    public int getHits(int timestamp) {
        // Remove entries older than 5 minutes (300 seconds) from the current timestamp
        while (!hits.isEmpty() && timestamp - hits.peekFirst() >= 300) {
            hits.removeFirst();
        }
        return hits.size();
    }
}
