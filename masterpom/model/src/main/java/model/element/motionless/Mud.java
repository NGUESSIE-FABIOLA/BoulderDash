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
public class Mud extends MotionlessElement {

	  /** The Constant SPRITE. */
	
	private static final Sprite sprite = new Sprite('.', Sprite.mapTileSet, new Rectangle(16, 0, 16, 16));

	public Mud() {
		super(sprite, Permeability.MINEABLE);
	}

}