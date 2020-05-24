/**
 * 
 */
package model.element.motionless;

import contract.Permeability;
import contract.Sprite;

/**
 * @author Heidy Kengne
 *
 */
public class ExitDoor extends MotionlessElement {
   
	/** The Exit Door's sprite*/
	private static final Sprite EXIT_DOOR = new Sprite('X');


    ExitDoor() {
    	super(EXIT_DOOR, Permeability.PENETRABLE);
		this.alive = true;

    }
}
