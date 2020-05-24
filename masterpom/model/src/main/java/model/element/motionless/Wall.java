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
public class Wall extends MotionlessElement implements IDestructible{

	/** The Star's sprite*/
	private static final Sprite WALL = new Sprite('W');
	
	public Wall() {
		super(WALL, Permeability.BLOCKING);
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
