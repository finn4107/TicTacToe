import java.util.Scanner;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class TicTacToe1v1 {
    static ArrayList<Integer> player1Positions = new ArrayList<Integer>();
    static ArrayList<Integer> player2Positions = new ArrayList<Integer>();

    public static void main(String[] args) {
        char[][] gameBoard = {{' ', '|', ' ', '|', ' '},
                              {'-', '+', '-', '+', '-'},
                              {' ', '|', ' ', '|', ' '},
                              {'-', '+', '-', '+', '-'},
                              {' ', '|', ' ', '|', ' '}};

        printGameBoard(gameBoard);

        while (true) {
            Scanner scanner = new Scanner(System.in);

            // Spieler 1 ist an der Reihe
            System.out.println("Spieler 1, bitte gib deine Position ein (1-9):");
            int player1Pos = scanner.nextInt();
            while (isPositionTaken(player1Pos)) {
                System.out.println(player1Pos + " ist bereits besetzt. Bitte erneut eingeben: ");
                player1Pos = scanner.nextInt();
            }
            while(player1Pos < 1 || player1Pos > 9) {
            	System.out.println(player1Pos + " ist keine Zahl von 1-9, bitte erneut eingeben: ");
            	player1Pos = scanner.nextInt();
            }
            placePiece(gameBoard, player1Pos, "player1");
            printGameBoard(gameBoard);

            if (checkWinner(player1Positions)) {
                System.out.println("Spieler 1 hat gewonnen!");
                break;
            } else if (isBoardFull()) {
                System.out.println("Unentschieden");
                break;
            }

            // Spieler 2 ist an der Reihe
            System.out.println("Spieler 2, bitte gib deine Position ein (1-9):");
            int player2Pos = scanner.nextInt();
            while (isPositionTaken(player2Pos)) {
                System.out.println(player2Pos + " ist bereits besetzt. Bitte erneut eingeben: ");
                player2Pos = scanner.nextInt();
            }
            while(player2Pos < 1 || player2Pos > 9) {
            	System.out.println(player2Pos + " ist keine Zahl von 1-9, bitte erneut eingeben: ");
            	player2Pos = scanner.nextInt();
            }
            placePiece(gameBoard, player2Pos, "player2");
            printGameBoard(gameBoard);

            if (checkWinner(player2Positions)) {
                System.out.println("Spieler 2 hat gewonnen!");
                break;
            } else if (isBoardFull()) {
                System.out.println("Unentschieden");
                break;
            }
        }
    }

    public static void printGameBoard(char[][] gameBoard) {
        for (char[] row : gameBoard) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    public static void placePiece(char[][] gameBoard, int pos, String user) {
        char symbol = ' ';
        if (user.equals("player1")) {
            symbol = 'X';
            player1Positions.add(pos);
        } else if (user.equals("player2")) {
            symbol = 'O';
            player2Positions.add(pos);
        }
        switch (pos) {
            case 1:
                gameBoard[0][0] = symbol;
                break;
            case 2:
                gameBoard[0][2] = symbol;
                break;
            case 3:
                gameBoard[0][4] = symbol;
                break;
            case 4:
                gameBoard[2][0] = symbol;
                break;
            case 5:
                gameBoard[2][2] = symbol;
                break;
            case 6:
                gameBoard[2][4] = symbol;
                break;
            case 7:
                gameBoard[4][0] = symbol;
                break;
            case 8:
                gameBoard[4][2] = symbol;
                break;
            case 9:
                gameBoard[4][4] = symbol;
                break;
            default:
                break;
        }
    }

    public static boolean isPositionTaken(int pos) {
        return player1Positions.contains(pos) || player2Positions.contains(pos);
    }

    public static boolean checkWinner(List<Integer> positions) {
        List<Integer> topRow = Arrays.asList(1, 2, 3);
        List<Integer> middleRow = Arrays.asList(4, 5, 6);
        List<Integer> bottomRow = Arrays.asList(7, 8, 9);
        List<Integer> leftColumn = Arrays.asList(1, 4, 7);
        List<Integer> middleColumn = Arrays.asList(2, 5, 8);
        List<Integer> rightColumn = Arrays.asList(3, 6, 9);
        List<Integer> diagonal1 = Arrays.asList(1, 5, 9);
        List<Integer> diagonal2 = Arrays.asList(7, 5, 3);

        List<List<Integer>> winningConditions = new ArrayList<List<Integer>>();
        winningConditions.add(topRow);
        winningConditions.add(middleRow);
        winningConditions.add(bottomRow);
        winningConditions.add(leftColumn);
        winningConditions.add(middleColumn);
        winningConditions.add(rightColumn);
        winningConditions.add(diagonal1);
        winningConditions.add(diagonal2);

        for (List<Integer> condition : winningConditions) {
            if (positions.containsAll(condition)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isBoardFull() {
        return player1Positions.size() + player2Positions.size() == 9;
    }
}
