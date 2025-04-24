import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TicTacToe game = new TicTacToe();

        System.out.println("Welcome to Tic Tac Toe!");
        game.printBoard();

        while (true) {
            System.out.print("Enter your move (1-9): ");
            int userMove = scanner.nextInt();

            game.makeMove(userMove, 'X');
            game.printBoard();

            if (game.checkWin('X')) {
                System.out.println("Player 1 has won!");
                break;
            }

            if (game.isBoardFull()) {
                System.out.println("Draw!");
                break;
            }

            int compMove = game.computerMove();
            System.out.println("Computer chose position: " + compMove);
            game.printBoard();

            if (game.checkWin('O')) {
                System.out.println("Computer has won!");
                break;
            }

            if (game.isBoardFull()) {
                System.out.println("Draw!");
                break;
            }
        }

        scanner.close();
    }
}
