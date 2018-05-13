// Author: Matt McGuiness
package battleship;

public class LightCruiser extends Ship {

    LightCruiser() {
	super(5);
    }
    
    @Override
    String getShipType() {
	return "light cruiser";
    }

}
