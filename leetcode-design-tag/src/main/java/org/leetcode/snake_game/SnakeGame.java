package org.leetcode.snake_game;

import java.util.*;

public class SnakeGame {
    private final int width;
    private final int height;
    private final int[][] food;
    private final Deque<int[]> snake;
    private final Set<String> occupied; // To keep track of occupied positions
    private int score;
    private int foodIndex;

    public SnakeGame(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        this.food = food;
        snake = new LinkedList<>();
        snake.offer(new int[]{0, 0}); // Snake starts at position (0, 0)
        occupied = new HashSet<>();
        occupied.add("0,0"); // Mark (0, 0) as occupied
        score = 0;
        foodIndex = 0;
    }

    public int move(String direction) {
        int[] head = snake.peekFirst(); // Current head position
        int[] next = getNextPosition(head, direction); // Calculate next position

        // Remove tail
        int[] tail = snake.pollLast();
        occupied.remove(tail[0] + "," + tail[1]); // Mark tail position as unoccupied

        String key = next[0] + "," + next[1];
        // Check if the snake collides with the border or itself
        if (next[0] < 0 || next[0] >= height || next[1] < 0 || next[1] >= width || occupied.contains(key)) {
            return -1; // Game over
        }

        // Add head
        snake.offerFirst(next);
        occupied.add(key); // Mark new head position as occupied

        // hecks if the snake's head position (next[0], next[1]) matches the position of
        // the current food item (food[foodIndex][0], food[foodIndex][1]).
        if (foodIndex < food.length && next[0] == food[foodIndex][0] && next[1] == food[foodIndex][1]) {
            score++;
            snake.offerLast(tail); // Grow the snake by adding the tail back
            occupied.add(tail[0] + "," + tail[1]); // Mark tail position as occupied
            foodIndex++;
        }

        return score;
    }

    private int[] getNextPosition(int[] curr, String direction) {
        int[] next = Arrays.copyOf(curr, 2);
        switch (direction) {
            case "U" -> next[0]--;
            case "D" -> next[0]++;
            case "L" -> next[1]--;
            case "R" -> next[1]++;
        }
        return next;
    }
}
