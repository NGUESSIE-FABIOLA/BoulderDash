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
public class Border extends MotionlessElement{

	/** The Border's sprite*/
	private static final Sprite BORDER = new Sprite('|');

	
    Border() {
        super(BORDER, Permeability.BLOCKING);
    }
}
