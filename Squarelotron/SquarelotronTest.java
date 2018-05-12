// Author: Matt McGuiness

package squarelotron;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SquarelotronTest {

	Squarelotron squarelotron1;

	@BeforeEach
	void setUp() throws Exception {
		squarelotron1 = new Squarelotron(4);
	}

	@Test
	void testSquarelotron() {
		assertEquals(4, squarelotron1.size);
		assertEquals(1, squarelotron1.squarelotron[0][0]);
		assertEquals(2, squarelotron1.squarelotron[0][1]);
		assertEquals(3, squarelotron1.squarelotron[0][2]);
		assertEquals(4, squarelotron1.squarelotron[0][3]);
		assertEquals(5, squarelotron1.squarelotron[1][0]);
		assertEquals(6, squarelotron1.squarelotron[1][1]);
		assertEquals(7, squarelotron1.squarelotron[1][2]);
		assertEquals(8, squarelotron1.squarelotron[1][3]);
		assertEquals(9, squarelotron1.squarelotron[2][0]);
		assertEquals(10, squarelotron1.squarelotron[2][1]);
		assertEquals(11, squarelotron1.squarelotron[2][2]);
		assertEquals(12, squarelotron1.squarelotron[2][3]);
		assertEquals(13, squarelotron1.squarelotron[3][0]);
		assertEquals(14, squarelotron1.squarelotron[3][1]);
		assertEquals(15, squarelotron1.squarelotron[3][2]);
		assertEquals(16, squarelotron1.squarelotron[3][3]);

	}

	@Test
	void testUpsideDownFlip() {
		assertEquals(13, squarelotron1.upsideDownFlip(1).squarelotron[0][0]);
		assertEquals(14, squarelotron1.upsideDownFlip(1).squarelotron[0][1]);
		assertEquals(15, squarelotron1.upsideDownFlip(1).squarelotron[0][2]);
		assertEquals(16, squarelotron1.upsideDownFlip(1).squarelotron[0][3]);
		assertEquals(9, squarelotron1.upsideDownFlip(1).squarelotron[1][0]);
		assertEquals(6, squarelotron1.upsideDownFlip(1).squarelotron[1][1]);
		assertEquals(7, squarelotron1.upsideDownFlip(1).squarelotron[1][2]);
		assertEquals(12, squarelotron1.upsideDownFlip(1).squarelotron[1][3]);
		assertEquals(5, squarelotron1.upsideDownFlip(1).squarelotron[2][0]);
		assertEquals(10, squarelotron1.upsideDownFlip(1).squarelotron[2][1]);
		assertEquals(11, squarelotron1.upsideDownFlip(1).squarelotron[2][2]);
		assertEquals(8, squarelotron1.upsideDownFlip(1).squarelotron[2][3]);
		assertEquals(1, squarelotron1.upsideDownFlip(1).squarelotron[3][0]);
		assertEquals(2, squarelotron1.upsideDownFlip(1).squarelotron[3][1]);
		assertEquals(3, squarelotron1.upsideDownFlip(1).squarelotron[3][2]);
		assertEquals(4, squarelotron1.upsideDownFlip(1).squarelotron[3][3]);

		assertEquals(1, squarelotron1.upsideDownFlip(2).squarelotron[0][0]);
		assertEquals(2, squarelotron1.upsideDownFlip(2).squarelotron[0][1]);
		assertEquals(3, squarelotron1.upsideDownFlip(2).squarelotron[0][2]);
		assertEquals(4, squarelotron1.upsideDownFlip(2).squarelotron[0][3]);
		assertEquals(5, squarelotron1.upsideDownFlip(2).squarelotron[1][0]);
		assertEquals(10, squarelotron1.upsideDownFlip(2).squarelotron[1][1]);
		assertEquals(11, squarelotron1.upsideDownFlip(2).squarelotron[1][2]);
		assertEquals(8, squarelotron1.upsideDownFlip(2).squarelotron[1][3]);
		assertEquals(9, squarelotron1.upsideDownFlip(2).squarelotron[2][0]);
		assertEquals(6, squarelotron1.upsideDownFlip(2).squarelotron[2][1]);
		assertEquals(7, squarelotron1.upsideDownFlip(2).squarelotron[2][2]);
		assertEquals(12, squarelotron1.upsideDownFlip(2).squarelotron[2][3]);
		assertEquals(13, squarelotron1.upsideDownFlip(2).squarelotron[3][0]);
		assertEquals(14, squarelotron1.upsideDownFlip(2).squarelotron[3][1]);
		assertEquals(15, squarelotron1.upsideDownFlip(2).squarelotron[3][2]);
		assertEquals(16, squarelotron1.upsideDownFlip(2).squarelotron[3][3]);
	}

	@Test
	void testMainDiagonalFlip() {
		assertEquals(1, squarelotron1.mainDiagonalFlip(1).squarelotron[0][0]);
		assertEquals(5, squarelotron1.mainDiagonalFlip(1).squarelotron[0][1]);
		assertEquals(9, squarelotron1.mainDiagonalFlip(1).squarelotron[0][2]);
		assertEquals(13, squarelotron1.mainDiagonalFlip(1).squarelotron[0][3]);
		assertEquals(2, squarelotron1.mainDiagonalFlip(1).squarelotron[1][0]);
		assertEquals(6, squarelotron1.mainDiagonalFlip(1).squarelotron[1][1]);
		assertEquals(7, squarelotron1.mainDiagonalFlip(1).squarelotron[1][2]);
		assertEquals(14, squarelotron1.mainDiagonalFlip(1).squarelotron[1][3]);
		assertEquals(3, squarelotron1.mainDiagonalFlip(1).squarelotron[2][0]);
		assertEquals(10, squarelotron1.mainDiagonalFlip(1).squarelotron[2][1]);
		assertEquals(11, squarelotron1.mainDiagonalFlip(1).squarelotron[2][2]);
		assertEquals(15, squarelotron1.mainDiagonalFlip(1).squarelotron[2][3]);
		assertEquals(4, squarelotron1.mainDiagonalFlip(1).squarelotron[3][0]);
		assertEquals(8, squarelotron1.mainDiagonalFlip(1).squarelotron[3][1]);
		assertEquals(12, squarelotron1.mainDiagonalFlip(1).squarelotron[3][2]);
		assertEquals(16, squarelotron1.mainDiagonalFlip(1).squarelotron[3][3]);
	}

	@Test
	void testRotateRight() {
		squarelotron1.rotateRight(-11);
		assertEquals(13, squarelotron1.squarelotron[0][0]);
		assertEquals(9, squarelotron1.squarelotron[0][1]);
		assertEquals(5, squarelotron1.squarelotron[0][2]);
		assertEquals(1, squarelotron1.squarelotron[0][3]);
		assertEquals(14, squarelotron1.squarelotron[1][0]);
		assertEquals(10, squarelotron1.squarelotron[1][1]);
		assertEquals(6, squarelotron1.squarelotron[1][2]);
		assertEquals(2, squarelotron1.squarelotron[1][3]);
		assertEquals(15, squarelotron1.squarelotron[2][0]);
		assertEquals(11, squarelotron1.squarelotron[2][1]);
		assertEquals(7, squarelotron1.squarelotron[2][2]);
		assertEquals(3, squarelotron1.squarelotron[2][3]);
		assertEquals(16, squarelotron1.squarelotron[3][0]);
		assertEquals(12, squarelotron1.squarelotron[3][1]);
		assertEquals(8, squarelotron1.squarelotron[3][2]);
		assertEquals(4, squarelotron1.squarelotron[3][3]);
	}

}
