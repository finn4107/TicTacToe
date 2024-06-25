import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;
public class TicTacToe {
	static ArrayList<Integer> playerPositions = new ArrayList<Integer>();
	static ArrayList<Integer> cpuPositions = new ArrayList<Integer>();
    public static void main(String[] args) {
        char [][] gameBoard = {{' ', '|', ' ', '|', ' '},

        {'-', '+', '-', '+', '-'},

        {' ', '|', ' ', '|', ' '},

        {'-', '+', '-', '+', '-'},

        {' ', '|', ' ', '|', ' '}};
        
    printGameBoard(gameBoard);

    while(true) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Gebe deine Position ein (1-9):");
        int playerPos = scanner.nextInt();
        while(playerPositions.contains(playerPos) || cpuPositions.contains(playerPositions)) {
        	System.out.println(playerPos + " ist bereits besetzt. Bitte erneut eingeben: ");
        	playerPos = scanner.nextInt();
        }
        while(playerPos < 1 || playerPos > 9) {
        	System.out.println(playerPos + " ist keine Zahl von 1-9, bitte erneut eingeben: ");
        	playerPos = scanner.nextInt();
        }
        	
        
        placePiece(gameBoard, playerPos, "player");
        
        String Resultat = checkWinner();
        if(Resultat.length() > 0) {
            System.out.println(Resultat);
            break;
        }
        
        Random random = new Random();
        int cpuPos = random.nextInt(9) + 1;
        while(playerPositions.contains(cpuPos) || cpuPositions.contains(cpuPos)) {
        	cpuPos = random.nextInt(9) + 1;
        }
        placePiece(gameBoard, cpuPos, "cpu");
            
        printGameBoard(gameBoard);
        Resultat = checkWinner();
        if(Resultat.length() > 0) {
            System.out.println(Resultat);
            break;
        }

    	
    }

    }
    public static void printGameBoard(char[][] gameBoard) {
        for(char[] row : gameBoard) {
            for(char c : row) {
            System.out.print(c);
        }
        System.out.println();
        }
    }
    public static void placePiece(char[][] gameBoard, int pos, String user) {
    	char symbol = ' ';
    	if(user.equals("player")) {
    		symbol = 'X';
    		playerPositions.add(pos);
    	} else if (user.equals("cpu")) {
    		symbol = '0';
    		cpuPositions.add(pos);
    	}
        switch(pos) {
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
    public static String checkWinner() {
    	
    	List topRow = Arrays.asList(1, 2, 3);
    	List middleRow = Arrays.asList(4, 5, 6);
    	List bottomRow = Arrays.asList(7, 8, 9);
    	List leftColumn = Arrays.asList(1, 4, 7);
    	List middleColumn = Arrays.asList(2, 5, 8);
    	List rightColumn = Arrays.asList(3, 6, 9);
    	List diagonal1 = Arrays.asList(1, 5, 9);
    	List diagonal2 = Arrays.asList(7, 5, 3);
    	
    	List<List>  winningConditions = new ArrayList<List>();
    	winningConditions.add(topRow);
    	winningConditions.add(middleRow);
    	winningConditions.add(bottomRow);
    	winningConditions.add(leftColumn);
    	winningConditions.add(middleColumn);
    	winningConditions.add(rightColumn);
    	winningConditions.add(diagonal1);
    	winningConditions.add(diagonal2);
    	
    	for(List l : winningConditions) {
    		if(playerPositions.containsAll(l)) {
    		return "Glueckwunsch, du hast gewonnen!";
    	} else if (cpuPositions.containsAll(l)) {
    		return "Die CPU hat gewonnen!";
    	} else if (playerPositions.size() + cpuPositions.size() == 9) {
    		return "Unentschieden";
    	}
    	}
    	
    	return "";
    }
}
