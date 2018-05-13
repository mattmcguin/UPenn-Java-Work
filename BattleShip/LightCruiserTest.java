package battleship;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LightCruiserTest {

    LightCruiser lightCruiser;
    
    @BeforeEach
    void setUp() throws Exception {
	lightCruiser = new LightCruiser();
    }

    @Test
    void testGetShipType() {
	assertEquals("light cruiser", lightCruiser.getShipType());
    }

    @Test
    void testLightCruiser() {
	assertEquals(5, lightCruiser.getLength());
    }

}
