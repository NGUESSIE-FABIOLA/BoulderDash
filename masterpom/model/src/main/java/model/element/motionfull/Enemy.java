/**
 * 
 */
package model.element.motionfull;

import contract.IDestructible;
import contract.Permeability;
import contract.Sprite;
import model.element.Map;

/**
 * @author Heidy Kengne
 *
 */
public abstract class Enemy extends MotionFullElement implements IDestructible{



	public Enemy(Sprite sprite, Map map) {
		super(sprite, Permeability.BLOCKING, map );
		
	}

	
	/**
	 * Checks if is alive.
     *
     * @return  alive
     */
	@Override
	public Boolean isAlive() {
		return this.alive;
	}

	
/**
 * Awaiting override
 * */
	@Override
	public void die() {
	}
}


