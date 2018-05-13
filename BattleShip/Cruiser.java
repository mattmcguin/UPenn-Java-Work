// Author: Matt McGuiness
package battleship;

public class Cruiser extends Ship {

    Cruiser() {
	super(6);
    }
    
    @Override
    String getShipType() {
	return "cruiser";
    }
}
