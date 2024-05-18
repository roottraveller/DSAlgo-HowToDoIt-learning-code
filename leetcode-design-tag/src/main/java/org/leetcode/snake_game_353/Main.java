package org.leetcode.snake_game_353;

public class Main {

    // https://leetcode.ca/all/353.html
    public static void main(String[] args) {
        int width = 3;
        int height = 2;
        int[][] food = {{1, 2}, {0, 1}};
        SnakeGame snakeGame = new SnakeGame(width, height, food);
        System.out.println(snakeGame.move("R")); // Returns 0
        System.out.println(snakeGame.move("D")); // Returns 0
        System.out.println(snakeGame.move("R")); // Returns 1
        System.out.println(snakeGame.move("U")); // Returns 1
        System.out.println(snakeGame.move("L")); // Returns 2
        System.out.println(snakeGame.move("U")); // Returns -1
    }
}