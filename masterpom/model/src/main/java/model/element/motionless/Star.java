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
public class Star extends MotionlessElement {

	  /** The Constant SPRITE. */
	private static final Sprite STAR = new Sprite('*');

    /**
     * Instantiates a new SpecialStoneWall.
     */
    Star() {
        super(STAR, Permeability.BLOCKING);
        this.alive = true;
        
    }
	    
}
