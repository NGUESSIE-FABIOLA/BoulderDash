/**
 * 
 */
package model.element.motionfull;

import contract.IGravitable;
import contract.Permeability;
import contract.Sprite;
import model.element.Map;

/**
 * @author Heidy Kengne
 *
 */
public class Rock extends MotionFullElement implements IGravitable {


	private static final Sprite ROCK = new Sprite('O');

	public Rock(Map map) {
		super(ROCK, Permeability.BLOCKING, map);
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
	
	public void fallLeft(){
		
	}
	
	public void fallRight(){
		
	}




}
