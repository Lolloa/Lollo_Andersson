
package uppgift3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class uppgift34 {
	static Scanner scanner = new Scanner(System.in);
	static Random random = new Random();
	static int player = 0;
	static int computer = 0;
	static boolean isRunning = true;
	static int count = 0;

	public static void main(String[] args) {
		int x = 0;
		//Skapar spelplanen
		String [] [] gameBoard= {
				{"1", "2", "3"},
				{"4", "5", "6"},
				{"7", "8", "9"}
		};
		System.out.println("Welcome to tic tac toe!");
		System.out.println("Choose a number between 1-9:");
		//Skriver ut spelplanen 
		printGameBoard(gameBoard);
		while(isRunning) {
			
			do {
				//F�rs�ker ta in en int mellan 1-9
			try {
			player = scanner.nextInt();
			x++;
			}catch (InputMismatchException e) {
				System.out.println("Only use numbers between 1-9");
				scanner.next();
			}
			}while(x==0);
			//S�ger till om talet �r f�r stort
			do {
			if(player > 9 || player < 1) {
				System.out.println("Only use numbers between 1-9");
				player = scanner.nextInt();
			}
			}while (player > 9 || player < 1);
			//Kallar p� metoden checkIfEmpty om spelaren kan l�gga p� ledig plats
			if(checkIfEmpty(gameBoard, player)) {
				makeMove(gameBoard);
			} else {//Annars
					while(checkIfEmpty(gameBoard, player) == false) {//k�rs tills ledig plats hittas	
						System.out.println("The place is taken");
						player=scanner.nextInt();
					}
					
					makeMove(gameBoard); //Skriver ut spelplanen n�r draget �r gjort
					
				
			}
			
			if(checkWin(gameBoard) == false) {
				printGameBoard(gameBoard);
				break;
			}
			
			if(count == 9) { //Kollar om spelplanen �r full
				System.out.println("Board is full");
				
			}
			computer = random.nextInt(9)+1;
			//Kallar p� metoden checkIfEmpty om datorn kan l�gga p� ledig plats
			if(checkIfEmpty(gameBoard, computer) && count!=9) {//k�rs tills ledig plats hittas och planen inte �r full 
				makeMove(gameBoard);
				} else {
						while(checkIfEmpty(gameBoard, computer) == false) {	
							computer = random.nextInt(9)+1;
						}
						
						makeMove(gameBoard);
						
					}
			if(checkWin(gameBoard) == false) {
				printGameBoard(gameBoard);
				break;
			}
		
			printGameBoard(gameBoard); //Skriver ut spelplanen
			
		}
	}

	private static boolean checkIfEmpty(String[][] gameBoard, int input) {
		String in = Integer.toString(input);
		boolean empty = false;
		
		for(int i= 0; i < gameBoard.length; i++) {
			for(int j = 0; j< gameBoard[i].length; j++) {
				//Kollar s� att den valda platsen inte inneh�ller X eller O
				if(gameBoard[i][j].equals(in) && !gameBoard[i][j].equals("X") && !gameBoard[i][j].equals("O") ) {
				
					empty = true;
					count ++; //R�knar platserna
					if(empty == false) {
						count--;
					}
				}
			}
		
		}
		if(count == 9) {
			empty = true;
		}
		return empty;
	
		
	}

//Metod som kollar om det blir tre i rad
	private static boolean checkWin(String[][] gameBoard) {
		if(gameBoard[0][0].equals("X") && gameBoard[0][1].equals("X") && gameBoard[0][2].equals("X")) {
			System.out.println("You win!");
			isRunning = false;
			
		}else if (gameBoard[1][0].equals("X") && gameBoard[1][1].equals("X") && gameBoard [1][2].equals("X")) {
			System.out.println("You win!");
			isRunning = false;
			
		}else if (gameBoard[2][0].equals("X") && gameBoard[2][1].equals("X") && gameBoard [2][2].equals("X")) {
			System.out.println("You win!");
			isRunning = false;
			
		}else if (gameBoard[0][0].equals("X") && gameBoard[1][0].equals("X") && gameBoard [2][0].equals("X")) {
			System.out.println("You win!");
			isRunning = false;
			
		}else if (gameBoard[0][1].equals("X") && gameBoard[1][1].equals("X") && gameBoard [2][1].equals("X")) {
			System.out.println("You win!");
			isRunning = false;
			
		}else if (gameBoard[0][2].equals("X") && gameBoard[1][2].equals("X") && gameBoard [2][2].equals("X")) {
			System.out.println("You win!");
			isRunning = false;
			
		}else if (gameBoard[0][0].equals("X") && gameBoard[1][1].equals("X") && gameBoard [2][2].equals("X")) {
			System.out.println("You win!");
			isRunning = false;
			
		}else if (gameBoard[2][0].equals("X") && gameBoard[1][1].equals("X") && gameBoard [0][2].equals("X")) {
			System.out.println("You win!");
			isRunning = false;
			
		}
		
		if(gameBoard[0][0].equals("O") && gameBoard[0][1].equals("O") && gameBoard[0][2].equals("O")) {
			System.out.println("Computer wins!");
			isRunning = false;
			
		}else if (gameBoard[1][0].equals("O") && gameBoard[1][1].equals("O") && gameBoard [1][2].equals("O")) {
			System.out.println("Computer wins!");
			isRunning = false;
			
		}else if (gameBoard[2][0].equals("O") && gameBoard[2][1].equals("O") && gameBoard [2][2].equals("O")) {
			System.out.println("Computer wins!");
			isRunning = false;
			
		}else if (gameBoard[0][0].equals("O") && gameBoard[1][0].equals("O") && gameBoard [2][0].equals("O")) {
			System.out.println("Computer wins!");
			isRunning = false;
			
		}else if (gameBoard[0][1].equals("O") && gameBoard[1][1].equals("O") && gameBoard [2][1].equals("O")) {
			System.out.println("Computer wins!");
			isRunning = false;
			
		}else if (gameBoard[0][2].equals("O") && gameBoard[1][2].equals("O") && gameBoard [2][2].equals("O")) {
			System.out.println("Computer wins!");
			isRunning = false;
			
		}else if (gameBoard[0][0].equals("O") && gameBoard[1][1].equals("O") && gameBoard [2][2].equals("O")) {
			System.out.println("Computer wins!");
			isRunning = false;
			
		}else if (gameBoard[2][0].equals("O") && gameBoard[1][1].equals("O") && gameBoard [0][2].equals("O")) {
			System.out.println("Computer wins!");
			isRunning = false;
			
		}
		return isRunning;
		
		
		
	}
//Metod som placerar X eller O p� r�tt index
	private static void makeMove(String[][] gameBoard) {
		
		switch (player) {
		case 1: gameBoard [0][0] = "X"; break;
		case 2: gameBoard [0][1] = "X";break;
		case 3: gameBoard [0][2] = "X";break;
		case 4: gameBoard [1][0] = "X";break;
		case 5: gameBoard [1][1] = "X";break;
		case 6: gameBoard [1][2] = "X";break;
		case 7: gameBoard [2][0] = "X";break;
		case 8: gameBoard [2][1] = "X";break;
		case 9: gameBoard [2][2] = "X";break;
		default : break;
		}
		
		switch (computer) {
		case 1: gameBoard [0][0] = "O";break;
		case 2: gameBoard [0][1] = "O"; break;
		case 3: gameBoard [0][2] = "O";break;
		case 4: gameBoard [1][0] = "O";break;
		case 5: gameBoard [1][1] = "O"; break;
		case 6: gameBoard [1][2] = "O"; break;
		case 7: gameBoard [2][0] = "O"; break;
		case 8: gameBoard [2][1] = "O"; break;
		case 9: gameBoard [2][2] = "O"; break;
		default : break;
		}
		
		
		
		
	}
//Metod som skriver ut spelplanen
	private static void printGameBoard(String[][] gameBoard) {
		for(int i= 0; i<gameBoard.length; i++) {
			for(int j = 0; j<gameBoard[i].length; j++){
				System.out.print("__" +gameBoard[i][j] + "__");
				System.out.print("|");
			}
			System.out.println();
					
		}
		
	}

}
