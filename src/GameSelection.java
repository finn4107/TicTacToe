import java.util.Scanner;

public class GameSelection {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Willkommen zu Tic Tac Toe!");
        // Erklärung des Spiels und des Spielbretts
        System.out.println("Tic Tac Toe ist ein Spiel fuer zwei Spieler, die abwechselnd ihre Symbole auf einem 3x3-Spielbrett platzieren.");
        System.out.println("Das Spielbrett ist wie folgt nummeriert:");
        System.out.println(" 1 | 2 | 3 ");
        System.out.println("---+---+---");
        System.out.println(" 4 | 5 | 6 ");
        System.out.println("---+---+---");
        System.out.println(" 7 | 8 | 9 ");
        System.out.println("Um eine Position zu waehlen, geben Sie einfach die entsprechende Zahl ein.");
        System.out.println("Waehle den Spielmodus:");
        System.out.println("1. Gegen den Computer");
        System.out.println("2. Gegen eine echte Person");
        int selection = scanner.nextInt();
        
        if (selection == 1) {
            
            TicTacToe.main(args);
        } else if (selection == 2) {
            
            TicTacToe1v1.main(args);
        } else {
            System.out.println("Ungültige Auswahl. Das Programm wird beendet.");
        }
    }
}
