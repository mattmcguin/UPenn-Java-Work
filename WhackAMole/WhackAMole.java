// Author: Matt McGuiness

package WhackAMole;

import java.util.*;

public class WhackAMole {

	int score;
	int molesLeft;
	int attemptsLeft;
	char[][] moleGrid;
	char[][] userGrid;

	WhackAMole(int numAttempts, int gridDimension) {
		attemptsLeft = numAttempts;

		moleGrid = new char[gridDimension][gridDimension];
		userGrid = new char[gridDimension][gridDimension];
		for (int i = 0; i < gridDimension; i++) {
			for (int j = 0; j < gridDimension; j++) {
				moleGrid[i][j] = '*';
				userGrid[i][j] = '*';
			}
		}
	}

	boolean place(int x, int y) {
		if (moleGrid[x][y] == '*') {
			moleGrid[x][y] = 'M';
			molesLeft++;
			return true;
		}
		return false;
	}

	void whack(int x, int y) {
		if (moleGrid[x][y] == 'M') {
			score++;
			molesLeft--;
			attemptsLeft--;
			userGrid[x][y] = 'W';
		} else {
			userGrid[x][y] = 'W';
			moleGrid[x][y] = 'W';
			attemptsLeft--;
		}

	}

	void printGridToUser() {
		for (int i = 0; i < userGrid.length; i++) {
			for (int j = 0; j < userGrid[0].length; j++) {
				System.out.print(" " + userGrid[i][j] + " ");
			}
			System.out.println();
		}
	}

	void printGrid() {
		for (int i = 0; i < moleGrid.length; i++) {
			for (int j = 0; j < moleGrid[0].length; j++) {
				System.out.print(" " + moleGrid[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Random rand = new Random();
		Scanner scanner = new Scanner(System.in);
		int numberOfMoles = 10;
		WhackAMole game = new WhackAMole(50, 10);

		for (int i = 0; i < numberOfMoles; i++) {
			int x = rand.nextInt(numberOfMoles - 1);
			int y = rand.nextInt(numberOfMoles - 1);

			boolean wasPlaced = game.place(x, y);

			if (!wasPlaced) {
				i--;
			}
		}

		while (game.attemptsLeft > 0) {
			int x = 10;
			int y = 10;
			System.out
					.println("You have whacked " + game.score + " mole(s) and there are " + game.molesLeft + " left.");
			System.out.println("You have " + game.attemptsLeft + " attempts left.");
			while (x < -1 || x > 9) {
				System.out.print("Please guess an x-coordinate: ");
				x = scanner.nextInt();
			}
			while (y < -1 || y > 9) {
				System.out.print("Please guess a y-coordinate: ");
				y = scanner.nextInt();
			}

			if (x == -1 && y == -1) {
				game.attemptsLeft = 0;
			} else {
				game.whack(x, y);
				game.printGridToUser();
			}
		}
		game.printGrid();
		scanner.close();
	}

}
