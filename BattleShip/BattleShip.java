// Author: Matt McGuiness
package battleship;

public class BattleShip extends Ship {
    
    BattleShip() {
	super(8);
    }

    @Override
    String getShipType() {
	return "battleship";
    }

}
