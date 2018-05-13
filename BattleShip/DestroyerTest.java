package battleship;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DestroyerTest {
    
    Destroyer destroyer;

    @BeforeEach
    void setUp() throws Exception {
	destroyer = new Destroyer();
    }

    @Test
    void testGetShipType() {
	assertEquals("destroyer", destroyer.getShipType());
    }

    @Test
    void testDestroyer() {
	assertEquals(4, destroyer.getLength());
    }

}
