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
