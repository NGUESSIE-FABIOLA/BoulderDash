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
public class Mud extends MotionlessElement{

	  /** The Constant SPRITE. */
    private static final Sprite SPRITE = new Sprite('m', "Ter.png");

    /**
     * Instantiates a new SpecialStoneWall.
     */
    Mud() {
        super(SPRITE, Permeability.PENETRABLE);
    }
	   
}
