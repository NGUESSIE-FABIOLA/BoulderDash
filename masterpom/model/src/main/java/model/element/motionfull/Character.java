/**
 * 
 */
package model.element.motionfull;

import java.awt.image.BufferedImage;

import contract.IDestructible;
import contract.Permeability;
import contract.Sprite;
import model.element.Map;

/**
 * @author Heidy Kengne
 *
 */
public class Character extends MotionFullElement implements IDestructible{

	private static final Sprite CHARACTER = new Sprite('H');
	
	BufferedImage buffer;
	

	
	
	public Character(Map map){
		super(CHARACTER, Permeability.BLOCKING, map);
		this.alive =true;
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
	 * Sets alive to false
	 */
	@Override
	public void die() {
		this.alive = false;
		
	}

}
