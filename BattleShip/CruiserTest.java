package battleship;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CruiserTest {
    
    Cruiser cruiser;

    @BeforeEach
    void setUp() throws Exception {
	cruiser = new Cruiser();
    }

    @Test
    void testGetShipType() {
	assertEquals("cruiser", cruiser.getShipType());
    }

    @Test
    void testCruiser() {
	assertEquals(6, cruiser.getLength());
    }

}
