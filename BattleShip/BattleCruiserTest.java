package battleship;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BattleCruiserTest {
    
    BattleCruiser battlecruiser;

    @BeforeEach
    void setUp() throws Exception {
	battlecruiser = new BattleCruiser();
    }

    @Test
    void testBattleCruiser() {
	assertEquals(7, battlecruiser.getLength());
    }
    
    @Test
    void testGetShipType() {
	assertEquals("battlecruiser", battlecruiser.getShipType());
    }

}
