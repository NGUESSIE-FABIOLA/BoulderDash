/**
 * 
 */
package model.element.motionless;

import java.awt.Rectangle;

import model.Permeability;
import model.Sprite;

/**
 * @author Heidy Kengne
 *
 */
public class Wall extends MotionlessElement {

	/** The Wall sprite*/

	private static final Sprite sprite = new Sprite('#', Sprite.mapTileSet, new Rectangle(0, 0, 16, 16));

	public Wall() {
		super(sprite, Permeability.BLOCKING);
	}
	
}
