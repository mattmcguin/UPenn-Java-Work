package battleship;

import java.util.*;

public class BattleshipGame {

    public static void main(String[] args) {
	Ocean ocean = new Ocean();
	
	System.out.println("Welcome to BATTLESHIP!\n");
	ocean.placeAllShipsRandomly();
	ocean.print();
	System.out.println("\nThe board is set."); 
	System.out.println("Each turn, you will be able to take 5 shots.");
	System.out.println("The input format should look like this: 1, 1; 0, 3; 7, 3; 9, 11; 12, 17\n");

	Scanner scanner = new Scanner(System.in);
	while (!ocean.isGameOver()) {
	    System.out.print("Please input 5 locations to shoot: ");
	    String userInput = scanner.nextLine();
	    String[] shots = userInput.split(";");
	    if (shots.length == 5) {
		for (int i = 0; i < 5; i++) {
		    String[] guess = shots[i].split(",");
		    int row = Integer.parseInt(guess[0].trim());
		    int column = Integer.parseInt(guess[1].trim());
		    System.out.println("Taking the shot at: " + shots[i]);
		    if (ocean.shootAt(row, column)) {
			System.out.println("HIT! You just hit " + ocean.getShipArray()[row][column].getShipType() + " at " + shots[i]);
		    } else {
			System.out.println("Shot MISSED!");
		    }
		}

		ocean.print();
	    } else {
		System.out.println("You entered invalid information. Please try again!");
	    }
	     
	}
	scanner.close();
	System.out.println("GAME OVER!");
	System.out.println("Your score was: ");
	System.out.println("Shots fired: " + ocean.getShotsFired());
	System.out.println("Ships hit: " + ocean.getHitCount());
	System.out.println("Ships sunk: " + ocean.getShipsSunk());
    }

}
