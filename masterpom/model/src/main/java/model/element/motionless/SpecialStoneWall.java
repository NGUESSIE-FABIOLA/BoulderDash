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
public class SpecialStoneWall extends MotionlessElement{

	  /** The Constant SPRITE. */
    private static final Sprite SPRITE = new Sprite('s', "Bling.png");

    /**
     * Instantiates a new SpecialStoneWall.
     */
    SpecialStoneWall() {
        super(SPRITE, Permeability.PENETRABLE);
    }
	    
}
