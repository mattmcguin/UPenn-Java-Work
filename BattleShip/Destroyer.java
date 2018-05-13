// Author: Matt McGuiness
package battleship;

public class Destroyer extends Ship {

    Destroyer() {
	super(4);
    }
    
    @Override
    String getShipType() {
	return "destroyer";
    }

}
