/**
 * 
 */
package model.element.motionless;

import java.awt.Rectangle;

import imodel.Permeability;
import imodel.Sprite;

/**
 * @author Heidy Kengne
 *
 */
public class Background extends MotionlessElement{
	
	/** The Background's sprite*/
	
	private static final Sprite sprite = new Sprite(' ', Sprite.mapTileSet, new Rectangle(32, 0, 16, 16));

	public Background() {
		super(sprite, Permeability.PENETRABLE);
	}

}