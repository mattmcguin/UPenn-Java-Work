// Author: Matt McGuiness

package squarelotron;

public class Squarelotron {

	int[][] squarelotron;
	int size;

	public Squarelotron(int n) {
		size = n;
		int currentVal = 1;
		squarelotron = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				squarelotron[i][j] = currentVal;
				currentVal++;
			}
		}
	}

	Squarelotron upsideDownFlip(int ring) {
		Squarelotron newSquarelotron = new Squarelotron(size);

		int lower = ring - 1;
		int upper = size - ring;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				// Gets the lower bound row and the upper bound row
				if (i == lower || i == upper) {
					if (j >= lower && j <= upper) {
						newSquarelotron.squarelotron[i][j] = this.squarelotron[size - 1 - i][j];
					}
				}
				// Gets the intermediate rows
				else if (i > lower && i < upper) {
					if (j == lower || j == upper) {
						newSquarelotron.squarelotron[i][j] = this.squarelotron[size - 1 - i][j];
					}
				}
			}
		}

		return newSquarelotron;
	}

	Squarelotron mainDiagonalFlip(int ring) {
		Squarelotron newSquarelotron = new Squarelotron(size);

		int lower = ring - 1;
		int upper = size - ring;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (i == lower || i == upper) {
					if (j >= lower && j <= upper) {
						newSquarelotron.squarelotron[i][j] = this.squarelotron[j][i];
					}
				} else if (i > lower && i < upper) {
					if (j == lower || j == upper) {
						newSquarelotron.squarelotron[i][j] = this.squarelotron[j][i];
					}
				}
			}
		}

		return newSquarelotron;
	}

	void rotateRight(int numberOfTurns) {
		Squarelotron newSquarelotron = new Squarelotron(size);

		// Account for negative turns
		if (numberOfTurns < 0) {
			numberOfTurns = -1 * (numberOfTurns % 4) - 2;
		}

		// Loop through the number of turns
		while (numberOfTurns > 0) {
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					newSquarelotron.squarelotron[i][j] = this.squarelotron[size - j - 1][i];
				}
			}
			numberOfTurns--;
		}

		// Replace old squarelotron with new
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				this.squarelotron[i][j] = newSquarelotron.squarelotron[i][j];
			}
		}

	}

	public static void main(String[] args) {
	}

}
