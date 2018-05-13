// Author: Matt McGuiness
package battleship;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ShipTest {

    Ocean ocean;
    BattleShip battleship;
    
    @BeforeEach
    void setUp() throws Exception {
	ocean = new Ocean();
	battleship = new BattleShip();
	battleship.placeShipAt(0, 8, false, ocean);
    }

    @Test
    void testOkToPlaceShipAt() {
	assertFalse(battleship.okToPlaceShipAt(0, 0, true, ocean));
    }

}
