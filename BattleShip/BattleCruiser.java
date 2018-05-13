// Author: Matt McGuiness
package battleship;

public class BattleCruiser extends Ship {
    
    BattleCruiser() {
	super(7);
    }

    @Override
    String getShipType() {
	return "battlecruiser";
    }

}
