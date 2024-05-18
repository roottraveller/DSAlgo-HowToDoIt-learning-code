package org.leetcode.hit_counter_362;


public class Main {

    // https://leetcode.ca/all/362.html
    public static void main(String[] args) {
        HitCounter counter = new HitCounter();
        counter.hit(1);
        counter.hit(2);
        counter.hit(3);
        System.out.println(counter.getHits(4)); // should return 3
        counter.hit(300);
        System.out.println(counter.getHits(300)); // should return 4
        System.out.println(counter.getHits(301)); // should return 3
    }
}