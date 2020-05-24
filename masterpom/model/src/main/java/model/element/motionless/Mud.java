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
public class Mud extends MotionlessElement implements IDestructible{

	  /** The Constant SPRITE. */
	private static final Sprite MUD = new Sprite('M');

    /**
     * Instantiates a new SpecialStoneWall.
     */
    Mud() {
        super(MUD, Permeability.PENETRABLE);
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
