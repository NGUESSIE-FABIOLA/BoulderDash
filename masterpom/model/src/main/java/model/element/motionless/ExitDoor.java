/**
 * 
 */
package model.element.motionless;

import model.element.Permeability;
import model.element.Sprite;

/**
 * @author Heidy Kengne
 *
 */
public class ExitDoor extends MotionlessElement {
   
	/** The Constant SPRITE. */
    private static final Sprite SPRITE = new Sprite('*', "Door.png");

    /**
     * Instantiates a new exitDoor.
     */
    ExitDoor() {
        super(SPRITE, Permeability.PENETRABLE);

    }
}
