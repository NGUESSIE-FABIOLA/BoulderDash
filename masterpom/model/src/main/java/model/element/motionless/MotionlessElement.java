/**
 * 
 */
package model.element.motionless;

import contract.Permeability;
import contract.Sprite;
import model.element.Element;

/**
 * @author Heidy Kengne
 *
 */
public abstract class MotionlessElement extends Element {


	MotionlessElement(final Sprite sprite, final Permeability permeability) {
	        super(sprite, permeability);
	    }
	   
	  
}
