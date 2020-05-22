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
public class Border extends MotionlessElement{

	  /** The Constant SPRITE. */
    private static final Sprite SPRITE = new Sprite('4', "ground.png");

    /**
     * Instantiates a new border.
     */
    Border() {
        super(SPRITE, Permeability.PENETRABLE);
    }
}
