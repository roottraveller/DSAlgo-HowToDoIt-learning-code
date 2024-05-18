package org.leetcode.tic_tac_toe_348;

public class Main {
    public static void main(String[] args) {
        // Create a TicTacToe game with a 3x3 board
        TicTacToe ticTacToe = new TicTacToe(3);

        // Make some moves and print the result
        System.out.println(ticTacToe.move(0, 0, 1)); // Returns 0 (no one wins)
        printBoard(ticTacToe);
        System.out.println(ticTacToe.move(0, 2, 2)); // Returns 0 (no one wins)
        printBoard(ticTacToe);
        System.out.println(ticTacToe.move(2, 2, 1)); // Returns 0 (no one wins)
        printBoard(ticTacToe);
        System.out.println(ticTacToe.move(1, 1, 2)); // Returns 0 (no one wins)
        printBoard(ticTacToe);
        System.out.println(ticTacToe.move(2, 0, 1)); // Returns 0 (no one wins)
        printBoard(ticTacToe);
        System.out.println(ticTacToe.move(1, 0, 2)); // Returns 0 (no one wins)
        printBoard(ticTacToe);
        System.out.println(ticTacToe.move(2, 1, 1)); // Returns 1 (player 1 wins)
        printBoard(ticTacToe);
    }

    // Helper method to print the current state of the board
    private static void printBoard(TicTacToe ticTacToe) {
        System.out.println("Current board:");
        System.out.println("------");
        for (int[] row : ticTacToe.getBoard()) {
            for (int cell : row) {
                System.out.print(cell == 0 ? " " : cell == 1 ? "X" : "O");
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println("------");
    }
}

