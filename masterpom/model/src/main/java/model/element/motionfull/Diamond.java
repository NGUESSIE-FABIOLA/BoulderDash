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
public class Diamond extends MotionFullElement implements IGravitable, IDestructible {
	private static final Sprite DIAMOND = new Sprite('D');

	
	public Diamond(Map map) {
		super(DIAMOND, Permeability.BLOCKING, map);
		this.alive = true;
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

	

	@Override
	public void fall() {
		
	}

	/**
	 * Decrements the objective
	 * */
	public void die(){
		this.alive=false;
		this.getMap().setObjective(this.getMap().getObjective()-1);
	}

   
}
