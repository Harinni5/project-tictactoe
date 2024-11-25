import java.util.Scanner;

public class TicTacToe {
    private static char[][] board = new char[3][3];  // 3x3 Tic-Tac-Toe board
    private static char currentPlayer = 'X';  // X starts first
    private static boolean gameWon = false;

    // Initialize the board with empty cells
    public static void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    // Display the current game board
    public static void displayBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    // Check if the current player has won the game
    public static boolean checkWin() {
        // Check rows, columns, and diagonals
        for (int i = 0; i < 3; i++) {
            // Check rows
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) {
                return true;
            }
            // Check columns
            if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer) {
                return true;
            }
        }
        // Check diagonals
        if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) {
            return true;
        }
        if (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer) {
            return true;
        }

        return false;
    }

    // Check if the board is full (for a draw)
    public static boolean checkDraw() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;  // There's still an empty space
                }
            }
        }
        return true;  // No empty space, it's a draw
    }

    // Allow the player to make a move
    public static void makeMove(int row, int col) {
        if (row < 0 || row > 2 || col < 0 || col > 2 || board[row][col] != ' ') {
            System.out.println("Invalid move! Try again.");
        } else {
            board[row][col] = currentPlayer;
        }
    }

    // Switch between players after each move
    public static void switchPlayer() {
        if (currentPlayer == 'X') {
            currentPlayer = 'O';
        } else {
            currentPlayer = 'X';
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        initializeBoard();
        
        while (true) {
            // Display the board
            displayBoard();
            
            // Prompt the current player for their move
            System.out.println("Player " + currentPlayer + ", enter your move (row and column [0-2]): ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            // Make the move
            makeMove(row, col);

            // Check for a win
            if (checkWin()) {
                displayBoard();
                System.out.println("Player " + currentPlayer + " wins!");
                break;
            }

            // Check for a draw
            if (checkDraw()) {
                displayBoard();
                System.out.println("It's a draw!");
                break;
            }

            // Switch players
            switchPlayer();
        }

        scanner.close();
    }
}
