import java.util.*;

public class TicTacToe {
    private char[] board;
    private final char USER = 'X';
    private final char COMPUTER = 'O';
    private final Random rand;

    public TicTacToe() {
        board = new char[9];
        Arrays.fill(board, ' ');
        rand = new Random();
    }

    public boolean makeMove(int pos, char player) {
        if (board[pos - 1] == ' ') {
            board[pos - 1] = player;
            return true;
        }
        return false;
    }

    public int computerMove() {
        List<Integer> available = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            if (board[i] == ' ') {
                available.add(i + 1);
            }
        }
        if (!available.isEmpty()) {
            int choice = available.get(rand.nextInt(available.size()));
            makeMove(choice, COMPUTER);
            return choice;
        }
        return -1;
    }

    public void printBoard() {
        for (int i = 0; i < 9; i += 3) {
            System.out.printf(" %c | %c | %c \n", board[i], board[i+1], board[i+2]);
            if (i < 6) {
                System.out.println("---+---+---");
            }
        }
    }

    public boolean checkWin(char player) {
        int[][] wins = {
            {0, 1, 2}, {3, 4, 5}, {6, 7, 8},  // Rows
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8},  // Columns
            {0, 4, 8}, {2, 4, 6}              // Diagonals
        };
        for (int[] win : wins) {
            if (board[win[0]] == player &&
                board[win[1]] == player &&
                board[win[2]] == player) {
                return true;
            }
        }
        return false;
    }

    public boolean isBoardFull() {
        for (char c : board) {
            if (c == ' ') return false;
        }
        return true;
    }
}
