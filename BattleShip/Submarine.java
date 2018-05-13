// Author: Matt McGuiness
package battleship;

public class Submarine extends Ship {

    Submarine() {
	super(3);
    }
    
    @Override
    String getShipType() {
	return "submarine";
    }

}
