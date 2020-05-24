/**
 * 
 */
package model.element.motionless;

import contract.IDestructible;
import contract.Permeability;
import contract.Sprite;

/**
 * @author Heidy Kengne
 *
 */
public class SpecialStoneWall extends MotionlessElement implements IDestructible{

	  /** The Constant SPRITE. */
	private static final Sprite SPECIAL_STONE_WALL = new Sprite('S');

    /**
     * Instantiates a new SpecialStoneWall.
     */
    SpecialStoneWall() {
        super(SPECIAL_STONE_WALL, Permeability.PENETRABLE);
        this.alive = true;
    }
	    
	/**
	 * Sets alive to false
	 */
	@Override
	public void die() {
		this.alive=false;
	}

	
}
