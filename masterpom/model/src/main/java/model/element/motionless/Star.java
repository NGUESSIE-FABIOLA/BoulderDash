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
public class Star extends MotionlessElement {

	  /** The Constant SPRITE. */
    private static final Sprite SPRITE = new Sprite('+', "star.png");

    /**
     * Instantiates a new SpecialStoneWall.
     */
    Star() {
        super(SPRITE, Permeability.PENETRABLE);
    }
	    
}
