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
public class ExitDoor extends MotionlessElement {
   
	/** The Exit Door's sprite*/

	private static final Sprite sprite = new Sprite('X', Sprite.mapTileSet, new Rectangle(0, 0, 16, 16));

	public ExitDoor() {
		super(sprite, Permeability.BLOCKING);
	}
}
