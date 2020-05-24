/**
 * 
 */
package model.element.motionfull;

import contract.Sprite;
import model.element.Map;

/**
 * @author Heidy Kengne
 *
 */
public class PointEnemy extends Enemy {

	
	private static final Sprite POINT_ENEMY = new Sprite('P');
	
	public PointEnemy(Map map) {
		super(POINT_ENEMY, map);
		this.alive = true;
	}

	
	/**
	 * Adds 10 points to the score
	 *  
	 */
	@Override
	public void die(){
		this.alive= false;
		this.getMap().setScore(this.getMap().getScore()+10);
	}

}
