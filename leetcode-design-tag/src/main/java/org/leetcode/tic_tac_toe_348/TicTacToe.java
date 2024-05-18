package org.leetcode.tic_tac_toe_348;

import lombok.Getter;

@Getter
public class TicTacToe {
    private final int[][] board;
    private final int n;

    public TicTacToe(int n) {
        this.n = n;
        this.board = new int[n][n];
    }

    public int move(int row, int col, int player) {
        if (row < 0 || row >= n || col < 0 || col >= n || board[row][col] != 0) {
            return 0; // Invalid move
        }

        board[row][col] = player; // Place player's mark

        // Check for win horizontally, vertically, and diagonally
        if (checkRow(row, player) || checkCol(col, player) || checkDiagonal(row, col, player)) {
            return player; // Player wins
        }

        return 0; // No winner yet
    }

    private boolean checkRow(int row, int player) {
        for (int col = 0; col < n; col++) {
            if (board[row][col] != player) {
                return false;
            }
        }
        return true;
    }

    private boolean checkCol(int col, int player) {
        for (int row = 0; row < n; row++) {
            if (board[row][col] != player) {
                return false;
            }
        }
        return true;
    }

    private boolean checkDiagonal(int row, int col, int player) {
        boolean leftDiagonal = true;
        boolean rightDiagonal = true;

        for (int i = 0; i < n; i++) {
            // Check left diagonal
            if (board[i][i] != player) {
                leftDiagonal = false;
            }

            // Check right diagonal
            if (board[i][n - i - 1] != player) {
                rightDiagonal = false;
            }
        }

        return leftDiagonal || rightDiagonal;
    }
}

