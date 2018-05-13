package battleship;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BattleShipTest {

    BattleShip battleship;

    @BeforeEach
    void setUp() throws Exception {
	battleship = new BattleShip();
    }

    // Ensure constructor is set up correctly
    @Test
    void testBattleShip() {
	assertEquals(8, battleship.getLength());
    }
    
    // Ensure shipType is correct
    @Test
    void testGetShipType() {
	assertEquals("battleship", battleship.getShipType());
    }

}
