// Author: Matt McGuiness
package battleship;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OceanTest {
    
    Ocean ocean;
    Submarine submarine;

    @BeforeEach
    void setUp() throws Exception {
	ocean = new Ocean();
	submarine = new Submarine();
	
	// Place a test sub at (0, 10)
	submarine.placeShipAt(0, 10, true, ocean);
	ocean.shootAt(0, 11);
	ocean.shootAt(0, 10);
	ocean.shootAt(0, 12);
    }

    @Test
    void testGetShotsFired() {
	assertEquals(3, ocean.getShotsFired());
    }

    @Test
    void testGetHitCount() {
	assertEquals(3, ocean.getHitCount());
    }

    @Test
    void testGetShipsSunk() {
	assertEquals(1, ocean.getShipsSunk());
    }

    @Test
    void testGetShipArray() {
	assertEquals("empty", ocean.getShipArray()[0][0].getShipType());
    }

    @Test
    void testIsGameOver() {
	assertFalse(ocean.isGameOver());
    }

    @Test
    void testIsOccupied() {
	assertFalse(ocean.isOccupied(0, 0));
    }

    @Test
    void testShootAt() {
	assertFalse(ocean.shootAt(0, 0));
	assertFalse(ocean.shootAt(0, 10));
    }

}
