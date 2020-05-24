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
public class Background extends MotionlessElement{
	
	/** The Background's sprite*/
	private static final Sprite BACKGROUND = new Sprite('_');
	 
	public Background() {
		super(BACKGROUND, Permeability.PENETRABLE);
		this.alive = true;
	}
	
}