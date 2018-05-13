// Author: Matt McGuiness
package battleship;

import java.util.*;

public class Ocean {
    
    int shotsFired;
    int hitCount;
    int shipsSunk;
    Ship [][] ships = new Ship[20][20];
    boolean [][] shotAt = new boolean[20][20];

    public Ocean() {
	for (int i = 0; i < 20; i++) {
	    for (int j = 0; j < 20; j++) {
		ships[i][j] = new EmptySea();
	    }
	}
	hitCount = 0;
	shotsFired = 0;
	shipsSunk = 0;
    }
    
    // Getters
    int getShotsFired() {
	return this.shotsFired;
    }

    int getHitCount() {
	return this.hitCount;
    }

    int getShipsSunk() {
	return this.shipsSunk;
    }
    
    Ship[][] getShipArray() {
	return this.ships;
    }

    // Checks if all ships are sunk
    boolean isGameOver() {
	return this.shipsSunk == 13;
    }

    void placeAllShipsRandomly() {
	int possibleRow, possibleColumn;
	boolean horizontal;
	Random random = new Random();
	
	// 1 BattleShip
	int numberOfBattleShips = 0;
	while (numberOfBattleShips < 1) {
	    possibleRow = random.nextInt(20);
	    possibleColumn = random.nextInt(20);
	    horizontal = random.nextBoolean();
	    
	    BattleShip battleship = new BattleShip();
	    if (battleship.okToPlaceShipAt(possibleRow, possibleColumn, horizontal, this)) {
		battleship.placeShipAt(possibleRow, possibleColumn, horizontal, this);
		numberOfBattleShips++;
	    }
	}
	
	// 1 BattleCruiser
	int numberOfBattleCruisers = 0;
	while (numberOfBattleCruisers < 1) {
	    possibleRow = random.nextInt(20);
	    possibleColumn = random.nextInt(20);
	    horizontal = random.nextBoolean();
	    
	    BattleCruiser battlecruiser = new BattleCruiser();
	    if (battlecruiser.okToPlaceShipAt(possibleRow, possibleColumn, horizontal, this)) {
		battlecruiser.placeShipAt(possibleRow, possibleColumn, horizontal, this);
		numberOfBattleCruisers++;
	    }
	}
	
	// 2 Cruiser
	int numberOfCruisers = 0;
	while (numberOfCruisers < 2) {
	    possibleRow = random.nextInt(20);
	    possibleColumn = random.nextInt(20);
	    horizontal = random.nextBoolean();
	    
	    Cruiser cruiser = new Cruiser();
	    if (cruiser.okToPlaceShipAt(possibleRow, possibleColumn, horizontal, this)) {
		cruiser.placeShipAt(possibleRow, possibleColumn, horizontal, this);
		numberOfCruisers++;
	    }
	}
	
	// 2 LightCruisers
	int numberOfLightCruisers = 0;
	while (numberOfLightCruisers < 2) {
	    possibleRow = random.nextInt(20);
	    possibleColumn = random.nextInt(20);
	    horizontal = random.nextBoolean();
	    
	    LightCruiser lightcruiser = new LightCruiser();
	    if (lightcruiser.okToPlaceShipAt(possibleRow, possibleColumn, horizontal, this)) {
		lightcruiser.placeShipAt(possibleRow, possibleColumn, horizontal, this);
		numberOfLightCruisers++;
	    }
	}
	
	// 3 Destroyers
	int numberOfDestroyers = 0;
	while (numberOfDestroyers < 3) {
	    possibleRow = random.nextInt(20);
	    possibleColumn = random.nextInt(20);
	    horizontal = random.nextBoolean();
	    
	    Destroyer destroyer = new Destroyer();
	    if (destroyer.okToPlaceShipAt(possibleRow, possibleColumn, horizontal, this)) {
		destroyer.placeShipAt(possibleRow, possibleColumn, horizontal, this);
		numberOfDestroyers++;
	    }
	}
	
	// 4 Submarines
	int numberOfSubmarines = 0;
	while (numberOfSubmarines < 4) {
	    possibleRow = random.nextInt(20);
	    possibleColumn = random.nextInt(20);
	    horizontal = random.nextBoolean();
	    
	    Submarine submarine = new Submarine();
	    if (submarine.okToPlaceShipAt(possibleRow, possibleColumn, horizontal, this)) {
		submarine.placeShipAt(possibleRow, possibleColumn, horizontal, this);
		numberOfSubmarines++;
	    }
	}
    }
    
    boolean isOccupied(int row, int column) {
	// If row or column is out of bounds
	if (row < 0 || row > 19 || column < 0 || column > 19) return false;
	
	// If there is a ship there
	if (ships[row][column].getShipType() != "empty") return true;
	
	return false;
    }
    
    boolean shootAt(int row, int column) {
	shotAt[row][column] = true;
	if (this.isOccupied(row, column)) {
	    if (!ships[row][column].isSunk()) {
		ships[row][column].shootAt(row, column);
		if (ships[row][column].isSunk()) this.shipsSunk++;
		this.shotsFired++;
		this.hitCount++;
		return true;
	    }
	}
	return false;
    }
    
   
    
    void print() {
	// Print out first line of board
	System.out.print("   ");
	for (int i = 0; i < 20; i++) {
	    System.out.print(String.format("%02d", i) + " ");
	}
	System.out.println();
	
	// Print out rest of board
	for (int i = 0; i < 20; i++) {
	    System.out.print(String.format("%02d", i) + " ");
	    for (int j = 0; j < 20 ; j++) {
		if (shotAt[i][j]) {
		System.out.print(" " + ships[i][j] + " ");
		} else {
		    System.out.print(" . ");
		}
	    }
	    System.out.println();
	}
    }

}
