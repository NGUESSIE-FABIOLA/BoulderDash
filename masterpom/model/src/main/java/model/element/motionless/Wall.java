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
public class Wall extends MotionlessElement{

	  /** The Constant SPRITE. */
    private static final Sprite SPRITE = new Sprite('w', "wall.png");

    /**
     * Instantiates a new SpecialStoneWall.
     */
    	Wall() {
        super(SPRITE, Permeability.PENETRABLE);
    }
	    
}
