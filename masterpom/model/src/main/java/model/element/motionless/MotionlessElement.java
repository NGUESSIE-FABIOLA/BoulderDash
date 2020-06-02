/**
 * 
 */
package model.element.motionless;

import model.Permeability;
import model.Sprite;
import model.element.Element;

/**
 * @author Heidy Kengne
 *
 */
public abstract class MotionlessElement extends Element {

	public MotionlessElement(Sprite sprite, Permeability permeability)
	{
		super(sprite, permeability);
	}
}
